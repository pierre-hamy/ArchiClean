package com.octo.kata.archiclean.domain;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Grid {


    private int height;
    private int width;
    private State[][] states;
    private List<Cell> cells;



    public Grid() {
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setStates(State[][] states) {
        this.states = states;
    }

    private State[][] getStates() {
        return states;
    }

    public Grid(String template) {
        String[] lines = template.split("\n");
        this.height = lines.length;
        this.width = lines[0].length();
        this.states = this.initializeGrid(width, height);

        this.cells = this.initializeGridCell(width,height);


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.states[y][x] = (lines[y].charAt(x) == State.ALIVE.value ? State.ALIVE : State.DEAD);
            }
        }
    }


    private State[][] initializeGrid(int width, int height) {
        State[][] grid = new State[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = State.DEAD;
            }
        }
        return grid;
    }

    private List<Cell> initializeGridCell(int width, int height) {
        State[][] grid = new State[height][width];
       List<Cell> cells = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = State.DEAD;
                cells.add(new Cell(x,y,State.DEAD));
            }
        }
        return cells;
    }

    public List<Cell> gridToCellArray() {
        List<Cell> cells = new ArrayList<>();
        final State[][] states = this.getStates();
        for (int y = 0; y < states.length; y++) {
            for (int x = 0; x < states[y].length; x++) {
                Cell cell = new Cell();
                cell.x = x;
                cell.y = y;
                cell.state = states[y][x];
                cells.add(cell);
            }

        }
        return cells;
    }

    public void computeEvolutions() {
        Pair<Integer, Integer> dimensions = getGridDimensions();
        Integer width = dimensions.getLeft();
        Integer height = dimensions.getRight();

        State[][] newStates = initializeGrid(width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                State nextState = State.DEAD;
                if (willStayAlive(x, y)) {
                    nextState = State.ALIVE;
                }
                newStates[y][x] = nextState;
            }
        }
        this.states = newStates;
    }

    private Pair<Integer, Integer> getGridDimensions() {
        State[][] states = this.states;
        return Pair.of(states[0].length, states.length);
    }


    private Integer countLivingNeighbours(int x, int y) {
        List<State> neighbours = new ArrayList<>();
        State[][] grid = this.states;
        if (x > 0) {
            neighbours.add(grid[y][x - 1]);
        }
        if (y > 0) {
            neighbours.add(grid[y - 1][x]);
        }
        if (x > 0 && y > 0) {
            neighbours.add(grid[y - 1][x - 1]);
        }
        if (x > 0 && hasNextRow(y)) {
            neighbours.add(grid[y + 1][x - 1]);
        }
        if (y > 0 && hasNextColumn(x, y)) {
            neighbours.add(grid[y - 1][x + 1]);
        }
        if (hasNextColumn(x, y)) {
            neighbours.add(grid[y][x + 1]);
        }
        if (hasNextColumn(x, y) && hasNextRow(y)) {
            neighbours.add(grid[y + 1][x + 1]);
        }
        if (hasNextRow(y)) {
            neighbours.add(grid[y + 1][x]);
        }
        return filterOutDeadCells(neighbours).size();
    }

    private Boolean willStayAlive(Integer x, Integer y) {

        State[][] states = this.states;
        int living = this.countLivingNeighbours(x, y);

        if (living == 3) {
            return true;
        }
        if (living == 2) {
            return states[y][x] == State.ALIVE;
        }
        return false;
    }


    private Boolean hasNextRow(Integer y) {
        return y < (this.states.length - 1);
    }

    private Boolean hasNextColumn(Integer x, Integer y) {
        return x < (this.states[y].length - 1);
    }

    private List<State> filterOutDeadCells(List<State> neighbours) {
        return neighbours
                .stream()
                .filter(value -> value == State.ALIVE)
                .collect(toList());
    }

}
