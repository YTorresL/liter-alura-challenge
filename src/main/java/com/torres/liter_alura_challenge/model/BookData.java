package com.torres.liter_alura_challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record BookData(
        @JsonAlias("title") String title,
        @JsonAlias("authors")List<AuthorData> authors,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer downloadCount
        ) {
}
