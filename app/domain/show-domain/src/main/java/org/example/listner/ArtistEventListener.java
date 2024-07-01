package org.example.listner;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.artist.Artist;
import org.example.entity.artist.ArtistGenre;
import org.example.event.ArtistEvent;
import org.example.event.ArtistEvent.EventType;
import org.example.usecase.artist.ArtistGenreUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistEventListener {

    private final ArtistGenreUseCase artistGenreUseCase;

    @EventListener
    public void handleArtistEvent(ArtistEvent artistEvent) {
        Artist artist = artistEvent.getArtist();
        List<UUID> genreIds = artistEvent.getGenreIds();
        ArtistEvent.EventType eventType = artistEvent.getEventType();
        handleArtistEvent(artist, genreIds, eventType);
    }

    private void handleArtistEvent(Artist artist, List<UUID> genreIds, EventType eventType) {
        switch (eventType) {
            case SAVE -> handleArtistSaved(artist, genreIds);
            case UPDATE -> handleArtistUpdated(artist, genreIds);
            default -> {
                break;
            }
        }
    }

    private void handleArtistSaved(Artist artist, List<UUID> genreIds) {
        List<ArtistGenre> artistGenres = artist.toArtistGenre(genreIds);
        artistGenreUseCase.saveAll(artistGenres);
    }

    private void handleArtistUpdated(Artist artist, List<UUID> newGenreIds) {
        List<ArtistGenre> currentGenres = artistGenreUseCase.findAllByArtistId(artist);

        List<UUID> currentGenreIds = currentGenres.stream()
            .map(ArtistGenre::getGenreId)
            .toList();

        List<UUID> genreIdsToAdd = newGenreIds.stream()
            .filter(id -> !currentGenreIds.contains(id))
            .toList();
        List<ArtistGenre> artistGenresToAdd = artist.toArtistGenre(genreIdsToAdd);
        artistGenreUseCase.saveAll(artistGenresToAdd);

        List<ArtistGenre> artistGenresToRemove = currentGenres.stream()
            .filter(ag -> !newGenreIds.contains(ag.getGenreId()))
            .toList();
        artistGenreUseCase.delete(artistGenresToRemove);
    }

}
