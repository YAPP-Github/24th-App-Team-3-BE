package org.example.dto.artist.response;

import java.util.List;
import java.util.UUID;
import org.example.entity.artist.ArtistGender;
import org.example.entity.artist.ArtistType;

public record ArtistDetailResponse(
    UUID id,
    String koreanName,
    String englishName,
    String country,
    ArtistGender artistGender,
    ArtistType artistType,
    List<String> genreNames
) {

}
