package com.octo.kata.archiclean.usecases;


import com.octo.kata.archiclean.domain.State;
import com.octo.kata.archiclean.domain.repositories.TemplateRepository;
import com.octo.kata.archiclean.infrastructure.filesystem.repositories.TemplateFileRepository;

import java.io.IOException;

import static com.octo.kata.archiclean.domain.Grid.prepareGame;

public class FindGridTemplateUseCase {


    private TemplateRepository templateRepository;

    public FindGridTemplateUseCase(TemplateFileRepository fileSystemRepository) {
        this.templateRepository = fileSystemRepository;
    }


    public State[][] execute(String path) throws IOException {

        final String templateContent = templateRepository.getTemplateContent(path);

        return prepareGame(templateContent);
    }

}
