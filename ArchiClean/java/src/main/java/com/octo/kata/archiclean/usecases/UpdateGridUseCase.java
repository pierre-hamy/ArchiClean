package com.octo.kata.archiclean.usecases;

import com.octo.kata.archiclean.domain.Cell;
import com.octo.kata.archiclean.domain.Grid;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

import static com.octo.kata.archiclean.domain.Cell.cellArrayToGrid;
import static com.octo.kata.archiclean.domain.Cell.getCellArrayDimensions;

public class UpdateGridUseCase {


    public Grid execute(List<Cell> cells) {

        Pair<Integer, Integer> cellArrayDimensions = getCellArrayDimensions(cells);
        Integer width = cellArrayDimensions.getLeft();
        Integer height = cellArrayDimensions.getRight();

        Grid grid = cellArrayToGrid(cells, width, height);
        grid.computeEvolutions();
        return grid;
    }
}
