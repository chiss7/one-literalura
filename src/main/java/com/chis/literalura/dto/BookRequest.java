package com.chis.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookRequest(
        String title,
        List<AuthorRequest> authors,
        List<String> languages,
        boolean copyright,
        @JsonAlias("download_count") Integer downloadCount
) {
}
