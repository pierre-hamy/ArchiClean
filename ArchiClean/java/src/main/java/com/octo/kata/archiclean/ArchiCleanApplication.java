package com.octo.kata.archiclean;

import com.octo.kata.archiclean.domain.State;
import com.octo.kata.archiclean.domain.Cell;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.octo.kata.archiclean.domain.Grid.initializeGrid;
import static java.util.stream.Collectors.toList;

@SpringBootApplication
@RestController
public class ArchiCleanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArchiCleanApplication.class, args);
    }


}
