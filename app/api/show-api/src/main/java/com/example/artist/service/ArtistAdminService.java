package com.example.artist.service;

import com.example.artist.service.dto.request.ArtistCreateServiceForm;
import com.example.artist.service.dto.request.ArtistUpdateServiceForm;
import com.example.artist.service.dto.response.ArtistDetailServiceFormResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.entity.artist.Artist;
import org.example.usecase.artist.ArtistUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistAdminService {

    private final ArtistUseCase artistUseCase;

    public void save(ArtistCreateServiceForm artistCreateServiceForm) {
        Artist artist = artistCreateServiceForm.toArtist();
        artistUseCase.save(artist, artistCreateServiceForm.genreIds());
    }

    public List<ArtistDetailServiceFormResponse> findAllArtist() {
        List<ArtistDetailResponse> artistDetailResponses = artistUseCase.findAllWithGenreNames();
        return artistDetailResponses.stream()
            .map(ArtistDetailServiceFormResponse::new)
            .toList();
    }

    public ArtistDetailServiceFormResponse findArtistById(UUID id) {
        return new ArtistDetailServiceFormResponse(artistUseCase.findArtistDetailById(id));
    }

    public void updateArtist(UUID id, ArtistUpdateServiceForm artistUpdateServiceForm) {
        Artist artist = artistUpdateServiceForm.toArtist();
        artistUseCase.updateArtist(id, artist, artistUpdateServiceForm.genreIds());
    }

    public void deleteArtist(UUID id) {
        artistUseCase.deleteArtist(id);
    }
}
