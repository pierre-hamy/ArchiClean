package com.octo.kata.archiclean.domain;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Grid {


    private String template;
    private int height;
    private int width;

    private State[][] states;

    public State[][] getStates() {
        return states;
    }

    public Grid(String template){
        String[] lines = template.split("\n");
        this.height = lines.length;
        this.width= lines[0].length();
        this.states = initializeGrid(width,height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.states[y][x] = (lines[y].charAt(x) == State.ALIVE.value ? State.ALIVE : State.DEAD);
            }
        }
    }


    private static State[][] initializeGrid(int width, int height) {
        State[][] grid = new State[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = State.DEAD;
            }
        }
        return grid;
    }

    public static List<Cell> gridToCellArray(State[][] grid) {
        List<Cell> cells = new ArrayList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Cell cell = new Cell();
                cell.x = x;
                cell.y = y;
                cell.alive = grid[y][x] == State.ALIVE;
                cells.add(cell);
            }

        }
        return cells;
    }

    public static State[][] computeEvolutions(State[][] grid) {
        Pair<Integer, Integer> dimensions = getGridDimensions(grid);
        Integer width = dimensions.getLeft();
        Integer height = dimensions.getRight();

        State[][] newGrid = initializeGrid(width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                State nextState = State.DEAD;
                if (willStayAlive(grid, x, y)) {
                    nextState = State.ALIVE;
                }
                newGrid[y][x] = nextState;
            }
        }
        return newGrid;
    }

    private static Pair<Integer, Integer> getGridDimensions(State[][] grid) {
        return Pair.of(grid[0].length, grid.length);
    }


    private static Integer countLivingNeighbours(State[][] grid, int x, int y) {
        List<State> neighbours = new ArrayList<>();
        if (x > 0) {
            neighbours.add(grid[y][x - 1]);
        }
        if (y > 0) {
            neighbours.add(grid[y - 1][x]);
        }
        if (x > 0 && y > 0) {
            neighbours.add(grid[y - 1][x - 1]);
        }
        if (x > 0 && hasNextRow(grid, y)) {
            neighbours.add(grid[y + 1][x - 1]);
        }
        if (y > 0 && hasNextColumn(grid, x, y)) {
            neighbours.add(grid[y - 1][x + 1]);
        }
        if (hasNextColumn(grid, x, y)) {
            neighbours.add(grid[y][x + 1]);
        }
        if (hasNextColumn(grid, x, y) && hasNextRow(grid, y)) {
            neighbours.add(grid[y + 1][x + 1]);
        }
        if (hasNextRow(grid, y)) {
            neighbours.add(grid[y + 1][x]);
        }
        return filterOutDeadCells(neighbours).size();
    }

    private static Boolean willStayAlive(State[][] grid, Integer x, Integer y) {
        int living = countLivingNeighbours(grid, x, y);
        if (living == 3) {
            return true;
        }
        if (living == 2) {
            return grid[y][x] == State.ALIVE;
        }
        return false;
    }


    private static Boolean hasNextRow(State[][] grid, Integer y) {
        return y < (grid.length - 1);
    }

    private static Boolean hasNextColumn(State[][] grid, Integer x, Integer y) {
        return x < (grid[y].length - 1);
    }

    private static List<State> filterOutDeadCells(List<State> neighbours) {
        return neighbours
                .stream()
                .filter(value -> value == State.ALIVE)
                .collect(toList());
    }

}
