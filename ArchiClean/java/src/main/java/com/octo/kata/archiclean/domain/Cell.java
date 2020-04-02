package com.octo.kata.archiclean.domain;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Cell {
    public Integer x;
    public Integer y;
    public Boolean alive;


    public static Pair<Integer, Integer> getCellArrayDimensions(List<Cell> cells) {
        Integer maxX = cells.get(0).x;
        Integer maxY = cells.get(0).y;

        for (Cell cell : cells) {
            if (cell.x > maxX) {
                maxX = cell.x;
            }
            if (cell.y > maxY) {
                maxY = cell.y;
            }
        }
        return Pair.of(maxX + 1, maxY + 1);
    }

    public static State[][] cellArrayToGrid(List<Cell> cells, Integer width, Integer height) {
        State[][] grid = new State[height][width];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[y][x] = State.DEAD;
            }
        }
        cells.forEach(cell -> {
            grid[cell.y][cell.x] = (cell.alive ? State.ALIVE : State.DEAD);
        });
        return grid;
    }
}
