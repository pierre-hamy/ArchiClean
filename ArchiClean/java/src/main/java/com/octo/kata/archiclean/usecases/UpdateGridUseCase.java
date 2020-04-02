package com.octo.kata.archiclean.usecases;

import com.octo.kata.archiclean.domain.Grid;

public class UpdateGridUseCase {


    public Grid execute(Grid grid) {

        grid.computeEvolutions();
        return grid;
    }
}
