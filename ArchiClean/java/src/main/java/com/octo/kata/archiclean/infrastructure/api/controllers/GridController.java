package com.octo.kata.archiclean.infrastructure.api.controllers;

import com.octo.kata.archiclean.adapters.CellMapper;
import com.octo.kata.archiclean.domain.Cell;
import com.octo.kata.archiclean.domain.State;
import com.octo.kata.archiclean.infrastructure.api.dto.CellDTO;
import com.octo.kata.archiclean.infrastructure.filesystem.repositories.TemplateFileRepository;
import com.octo.kata.archiclean.usecases.FindGridTemplateUseCase;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.octo.kata.archiclean.domain.Cell.cellArrayToGrid;
import static com.octo.kata.archiclean.domain.Cell.getCellArrayDimensions;
import static com.octo.kata.archiclean.domain.Grid.computeEvolutions;
import static com.octo.kata.archiclean.domain.Grid.gridToCellArray;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GridController {


    private FindGridTemplateUseCase findGridTemplateUseCase;
    private TemplateFileRepository fileSystemRepository;

    public GridController() {
        this.fileSystemRepository = new TemplateFileRepository();
        this.findGridTemplateUseCase = new FindGridTemplateUseCase(fileSystemRepository);
    }

    @GetMapping(value = "/grid", produces = APPLICATION_JSON_VALUE)
    public List<CellDTO> getFromTemplate(@RequestParam("template") String template) throws IOException {

        State[][] grid = this.findGridTemplateUseCase.execute(template);
        return CellMapper.fromDomainListToApiList(gridToCellArray(grid));
    }

    @PostMapping(value = "/grid", produces = APPLICATION_JSON_VALUE)
    public List<CellDTO> evolveGrid(@RequestBody List<Cell> cells) {
        Pair<Integer, Integer> cellArrayDimensions = getCellArrayDimensions(cells);
        Integer width = cellArrayDimensions.getLeft();
        Integer height = cellArrayDimensions.getRight();

        State[][] grid = cellArrayToGrid(cells, width, height);
        State[][] newGrid = computeEvolutions(grid);
        return CellMapper.fromDomainListToApiList(gridToCellArray(newGrid));
    }

}
