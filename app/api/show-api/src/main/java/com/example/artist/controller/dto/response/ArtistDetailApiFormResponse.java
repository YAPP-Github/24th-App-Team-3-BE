package com.example.artist.controller.dto.response;

import com.example.artist.service.dto.response.ArtistDetailServiceFormResponse;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.artist.ArtistGender;
import org.example.entity.artist.ArtistType;

@Builder
public record ArtistDetailApiFormResponse(
    UUID id,
    String koreanName,
    String englishName,
    String country,
    ArtistGender artistGender,
    ArtistType artistType,
    List<String> genreNames
) {

    public ArtistDetailApiFormResponse(
        ArtistDetailServiceFormResponse artistDetailServiceFormResponse) {
        this(
            artistDetailServiceFormResponse.id(),
            artistDetailServiceFormResponse.koreanName(),
            artistDetailServiceFormResponse.englishName(),
            artistDetailServiceFormResponse.country(),
            artistDetailServiceFormResponse.artistGender(),
            artistDetailServiceFormResponse.artistType(),
            artistDetailServiceFormResponse.genreNames()
        );
    }

}
