package com.octo.kata.archiclean.usecases;


import com.octo.kata.archiclean.domain.repositories.TemplateRepository;
import com.octo.kata.archiclean.infrastructure.filesystem.repositories.TemplateFileRepository;

import java.io.IOException;

public class FindGridTemplateUseCase {


    private TemplateRepository templateRepository;

    public FindGridTemplateUseCase(TemplateFileRepository fileSystemRepository) {
        this.templateRepository = fileSystemRepository;
    }


    public String execute(String path) throws IOException {

        return templateRepository.getTemplateContent(path);
    }

}
