package com.octo.kata.archiclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ArchiCleanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArchiCleanApplication.class, args);
    }


}
