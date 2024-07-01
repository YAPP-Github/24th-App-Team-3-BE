package com.example.genre.controller.dto.request;

import com.example.genre.service.dto.request.GenreUpdateServiceForm;
import jakarta.validation.constraints.NotNull;

public record GenreUpdateApiForm(
    @NotNull(message = "장르 이름은 필수 요청값 입니다.")
    String name
) {

    public GenreUpdateServiceForm toGenreUpdateServiceForm() {
        return new GenreUpdateServiceForm(name);

    }
}
