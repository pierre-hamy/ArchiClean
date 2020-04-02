package com.octo.kata.archiclean.infrastructure.api.dto;

public class CellDTO {

    Integer x;
    Integer y;
    public Boolean alive;

    public CellDTO() {
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
}
