package com.octo.kata.archiclean.infrastructure.api.controllers;

import com.octo.kata.archiclean.adapters.CellMapper;
import com.octo.kata.archiclean.domain.Cell;
import com.octo.kata.archiclean.domain.Grid;
import com.octo.kata.archiclean.infrastructure.api.dto.CellDTO;
import com.octo.kata.archiclean.infrastructure.filesystem.repositories.TemplateFileRepository;
import com.octo.kata.archiclean.usecases.FindGridTemplateUseCase;
import com.octo.kata.archiclean.usecases.UpdateGridUseCase;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.octo.kata.archiclean.domain.Grid.gridToCellArray;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GridController {


    private FindGridTemplateUseCase findGridTemplateUseCase;
    private UpdateGridUseCase updateGridUseCase;
    private TemplateFileRepository fileSystemRepository;

    public GridController() {
        this.updateGridUseCase = new UpdateGridUseCase();
        this.fileSystemRepository = new TemplateFileRepository();
        this.findGridTemplateUseCase = new FindGridTemplateUseCase(fileSystemRepository);
    }

    @GetMapping(value = "/grid", produces = APPLICATION_JSON_VALUE)
    public List<CellDTO> getFromTemplate(@RequestParam("template") String template) throws IOException {

        Grid grid = this.findGridTemplateUseCase.execute(template);
        return CellMapper.fromDomainListToApiList(gridToCellArray(grid.getStates()));
    }

    @PostMapping(value = "/grid", produces = APPLICATION_JSON_VALUE)
    public List<CellDTO> evolveGrid(@RequestBody List<Cell> cells) {


        Grid returnedGrid = this.updateGridUseCase.execute(cells);

        return CellMapper.fromDomainListToApiList(gridToCellArray(returnedGrid.getStates()));
    }

}
