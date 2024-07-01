package org.example.entity.artist;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_artist_genre")
public class ArtistGenre extends BaseEntity {

    @Column(name = "artist_id", nullable = false)
    private UUID artistId;

    @Column(name = "genre_id", nullable = false)
    private UUID genreId;

    @Builder
    private ArtistGenre(UUID artistId, UUID genreId) {
        this.artistId = artistId;
        this.genreId = genreId;
    }
}