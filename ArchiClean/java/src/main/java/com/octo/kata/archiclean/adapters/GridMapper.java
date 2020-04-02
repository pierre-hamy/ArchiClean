package com.octo.kata.archiclean.adapters;

import com.octo.kata.archiclean.domain.Cell;
import com.octo.kata.archiclean.domain.Grid;
import com.octo.kata.archiclean.domain.State;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class GridMapper {


    public static Grid fromApiToDomain(List<Cell> in) {

        Pair<Integer, Integer> cellArrayDimensions = getCellArrayDimensions(in);
        Integer width = cellArrayDimensions.getLeft();
        Integer height = cellArrayDimensions.getRight();

        return  buildGridFromCell(in, width, height);

    }


    private static Grid buildGridFromCell(List<Cell> cells, Integer width, Integer height) {
        State[][] grid = new State[height][width];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[y][x] = State.DEAD;
            }
        }
        cells.forEach(cell -> grid[cell.getY()][cell.getX()] = (cell.getAlive() ? State.ALIVE : State.DEAD));
        Grid returnedGrid = new Grid();
        returnedGrid.setHeight(height);
        returnedGrid.setWidth(width);
        returnedGrid.setStates(grid);

        return returnedGrid;
    }


    private static Pair<Integer, Integer> getCellArrayDimensions(List<Cell> cells) {
        Integer maxX = cells.get(0).getX();
        Integer maxY = cells.get(0).getY();

        for (Cell cell : cells) {
            if (cell.getX() > maxX) {
                maxX = cell.getX();
            }
            if (cell.getY() > maxY) {
                maxY = cell.getY();
            }
        }
        return Pair.of(maxX + 1, maxY + 1);
    }

}
