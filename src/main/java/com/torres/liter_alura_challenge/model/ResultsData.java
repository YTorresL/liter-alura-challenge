package com.torres.liter_alura_challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record ResultsData(
        @JsonAlias("Title")List<BookData> books
        ) {
}
