package com.example.genre.service.dto.request;

import org.example.entity.genre.Genre;

public record GenreCreateServiceForm(
    String name
) {
    public Genre toGenre() {
        return Genre.builder().name(name).build();

    }
}
