package com.example.genre.controller.dto.response;

import java.util.UUID;

public record GenreNameApiFormResponse(
    UUID id,
    String name
) {

}
