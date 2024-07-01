package com.example.artist.service.dto.request;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGender;
import org.example.entity.artist.ArtistType;

@Builder
public record ArtistCreateServiceForm(
    String koreanName,
    String englishName,
    String country,
    ArtistGender artistGender,
    ArtistType artistType,
    List<UUID> genreIds
) {

    public Artist toArtist() {
        return Artist.builder()
            .koreanName(koreanName)
            .englishName(englishName)
            .country(country)
            .artistGender(artistGender)
            .artistType(artistType)
            .build();
    }
}
