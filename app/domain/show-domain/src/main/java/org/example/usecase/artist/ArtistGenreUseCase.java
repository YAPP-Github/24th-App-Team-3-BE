package org.example.usecase.artist;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGenre;
import org.example.repository.artist.ArtistGenreRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArtistGenreUseCase {

    private final ArtistGenreRepository artistGenreRepository;

    @Transactional
    public void saveAll(List<ArtistGenre> artistGenres) {
        artistGenreRepository.saveAll(artistGenres);
    }


    public List<ArtistGenre> findAllByArtistId(Artist artist) {
        return artistGenreRepository.findArtistGenresByArtistId(artist.getId());
    }

    @Transactional
    public void delete(List<ArtistGenre> artistGenres) {
        artistGenres.forEach(artistGenre -> artistGenre.updateDeleteStatus(true));
    }
}
