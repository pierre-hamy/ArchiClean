package com.octo.kata.archiclean.adapters;

import com.octo.kata.archiclean.domain.Cell;
import com.octo.kata.archiclean.infrastructure.api.dto.CellDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CellMapper {

    private static CellDTO fromDomainToApi(Cell item) {
        CellDTO cellDTO = new CellDTO();
        cellDTO.setX(item.getX());
        cellDTO.setY(item.getY());
        cellDTO.setAlive(item.getAlive());

        return cellDTO;
    }


    public static List<CellDTO> fromDomainListToApiList(List<Cell> in){

        return in.stream().map(CellMapper::fromDomainToApi).collect(Collectors.toList());

    }
}
