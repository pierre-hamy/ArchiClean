package com.octo.kata.archiclean.usecases;


import com.octo.kata.archiclean.domain.Grid;
import com.octo.kata.archiclean.domain.repositories.TemplateRepository;
import com.octo.kata.archiclean.infrastructure.filesystem.repositories.TemplateFileRepository;

import java.io.IOException;

public class FindGridTemplateUseCase {


    private TemplateRepository templateRepository;

    public FindGridTemplateUseCase(TemplateFileRepository fileSystemRepository) {
        this.templateRepository = fileSystemRepository;
    }


    public Grid execute(String path) throws IOException {

        final String templateContent = templateRepository.getTemplateContent(path);
        return new Grid(templateContent);
    }

}
