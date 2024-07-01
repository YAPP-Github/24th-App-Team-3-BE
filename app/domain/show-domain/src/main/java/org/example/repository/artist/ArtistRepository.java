package org.example.repository.artist;

import java.util.UUID;
import org.example.entity.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, UUID>, ArtistQuerydslRepository {

}
