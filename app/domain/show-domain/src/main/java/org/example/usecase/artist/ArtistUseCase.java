package org.example.usecase.artist;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.artist.response.ArtistDetailResponse;
import org.example.entity.artist.Artist;
import org.example.error.ArtistError;
import org.example.event.ArtistEvent;
import org.example.event.ArtistEvent.EventType;
import org.example.exception.BusinessException;
import org.example.repository.artist.ArtistRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArtistUseCase {

    private final ArtistRepository artistRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void save(Artist artist, List<UUID> genreIds) {
        artistRepository.save(artist);
        eventPublisher.publishEvent(new ArtistEvent(this, artist, genreIds, EventType.SAVE));
    }

    public List<ArtistDetailResponse> findAllWithGenreNames() {
        return artistRepository.findAllWithGenreNames();
    }

    public ArtistDetailResponse findArtistDetailById(UUID id) {
        return artistRepository.findArtistWithGenreNamesById(id)
            .orElseThrow(() -> new BusinessException(ArtistError.ENTITY_NOT_FOUND_ERROR));
    }

    @Transactional
    public void updateArtist(UUID id, Artist newArtist, List<UUID> genreIds) {
        Artist artist = findArtistById(id);
        artist.changeArtist(newArtist);
        eventPublisher.publishEvent(new ArtistEvent(this, artist, genreIds, EventType.UPDATE));
    }

    @Transactional
    public void deleteArtist(UUID id) {
        Artist artist = findArtistById(id);
        artist.updateDeleteStatus(true);
    }

    private Artist findArtistById(UUID id) {
        return artistRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ArtistError.ENTITY_NOT_FOUND_ERROR));
    }

}

