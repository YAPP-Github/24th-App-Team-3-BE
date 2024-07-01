package com.example.artist.service.dto.response;

import java.util.List;
import java.util.UUID;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.entity.artist.ArtistGender;
import org.example.entity.artist.ArtistType;

public record ArtistDetailServiceFormResponse(
    UUID id,
    String koreanName,
    String englishName,
    String country,
    ArtistGender artistGender,
    ArtistType artistType,
    List<String> genreNames
) {
    public ArtistDetailServiceFormResponse(ArtistDetailResponse artistDetailResponse) {
        this(
            artistDetailResponse.id(),
            artistDetailResponse.koreanName(),
            artistDetailResponse.englishName(),
            artistDetailResponse.country(),
            artistDetailResponse.artistGender(),
            artistDetailResponse.artistType(),
            artistDetailResponse.genreNames()
        );
    }

}
