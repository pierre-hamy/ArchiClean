package com.octo.kata.archiclean.domain;


public enum State {
    DEAD(' '),
    ALIVE('o');

    public char value;

    State(char value) {
        this.value = value;
    }
}
