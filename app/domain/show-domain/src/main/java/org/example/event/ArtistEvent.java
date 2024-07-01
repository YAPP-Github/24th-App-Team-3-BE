package org.example.event;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import org.example.entity.artist.Artist;
import org.springframework.context.ApplicationEvent;

@Getter
public class ArtistEvent extends ApplicationEvent {

    public enum EventType {
        SAVE,
        UPDATE
    }

    private final Artist artist;
    private final List<UUID> genreIds;
    private final EventType eventType;

    public ArtistEvent(Object source, Artist artist, List<UUID> genreIds, EventType eventType) {
        super(source);
        this.artist = artist;
        this.genreIds = genreIds;
        this.eventType = eventType;
    }

}
