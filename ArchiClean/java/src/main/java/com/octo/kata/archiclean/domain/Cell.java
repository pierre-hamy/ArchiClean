package com.octo.kata.archiclean.domain;

public class Cell {
    Integer x;
    Integer y;
    State state;

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Boolean getAlive() {
        return state.equals(State.ALIVE);
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setState(State state) {
        this.state = state;
    }
}
