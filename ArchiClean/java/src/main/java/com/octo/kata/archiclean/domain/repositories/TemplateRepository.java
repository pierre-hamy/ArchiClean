package com.octo.kata.archiclean.domain.repositories;

import java.io.IOException;

public interface TemplateRepository {

    String getTemplateContent(String path) throws IOException;

}
