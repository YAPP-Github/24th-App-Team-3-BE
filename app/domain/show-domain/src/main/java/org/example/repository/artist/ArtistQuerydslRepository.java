package org.example.repository.artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.dto.artist.response.ArtistDetailResponse;

public interface ArtistQuerydslRepository {

    List<ArtistDetailResponse> findAllWithGenreNames();

    Optional<ArtistDetailResponse> findArtistWithGenreNamesById(UUID id);
}
