package com.octo.kata.archiclean.infrastructure.api.controllers;

import com.octo.kata.archiclean.domain.State;
import com.octo.kata.archiclean.domain.Cell;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.octo.kata.archiclean.domain.Cell.cellArrayToGrid;
import static com.octo.kata.archiclean.domain.Cell.getCellArrayDimensions;
import static com.octo.kata.archiclean.domain.Grid.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GridController {

    @GetMapping(value = "/grid", produces = APPLICATION_JSON_VALUE)
    public List<Cell> getFromTemplate(@RequestParam("template") String template) throws IOException {
        File file = new ClassPathResource("grids/" + template + ".grid").getFile();
        String fileContent = FileUtils.readFileToString(file, UTF_8);
        State[][] grid = initGridFromTemplate(fileContent);
        List<Cell> cells = gridToCellArray(grid);
        return cells;
    }

    @PostMapping(value = "/grid", produces = APPLICATION_JSON_VALUE)
    public List<Cell> evolveGrid(@RequestBody List<Cell> cells) {
        Pair<Integer, Integer> cellArrayDimensions = getCellArrayDimensions(cells);
        Integer width = cellArrayDimensions.getLeft();
        Integer height = cellArrayDimensions.getRight();

        State[][] grid = cellArrayToGrid(cells, width, height);
        State[][] newGrid = computeEvolutions(grid);
        return gridToCellArray(newGrid);
    }

}
