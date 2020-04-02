package com.octo.kata.archiclean.infrastructure.filesystem.repositories;

import com.octo.kata.archiclean.domain.repositories.TemplateRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;


@Repository
public class TemplateFileRepository implements TemplateRepository {

    @Override
    public String getTemplateContent(String path) throws IOException {
        File file = new ClassPathResource("grids/" + path + ".grid").getFile();
        return FileUtils.readFileToString(file, UTF_8);
    }
}
