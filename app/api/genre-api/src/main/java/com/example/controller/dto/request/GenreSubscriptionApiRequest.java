package com.example.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

public record GenreSubscriptionApiRequest(
    @Schema(description = "장르 ID 목록")
    @NotEmpty(message = "장르 ID가 최소 하나 이상 포함되어야 합니다.")
    List<UUID> genreIds
) {

}
