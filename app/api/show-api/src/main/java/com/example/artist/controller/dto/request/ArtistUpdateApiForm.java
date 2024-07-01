package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistUpdateServiceForm;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import org.example.entity.artist.ArtistGender;
import org.example.entity.artist.ArtistType;

public record ArtistUpdateApiForm(
    @NotNull(message = "아티스트의 한국 이름은 필수 요청값 입니다.")
    String koreanName,

    @NotNull(message = "아티스트의 영어 이름은 필수 요청값 입니다.")
    String englishName,

    @NotNull(message = "아티스트의 국적은 필수 요청값 입니다.")
    String country,

    @NotNull(message = "아티스트의 성별은 필수 요청값 입니다.")
    ArtistGender artistGender,

    @NotNull(message = "아티스트의 타입은 필수 요청값 입니다.")
    ArtistType artistType,

    @NotNull(message = "아티스트의 장르Id는 필수 요청값 입니다.")
    List<UUID> genreIds
) {

    public ArtistUpdateServiceForm toArtistUpdateServiceForm() {
        return ArtistUpdateServiceForm.builder()
            .koreanName(koreanName)
            .englishName(englishName)
            .country(country)
            .artistGender(artistGender)
            .artistType(artistType)
            .genreIds(genreIds)
            .build();

    }

}
