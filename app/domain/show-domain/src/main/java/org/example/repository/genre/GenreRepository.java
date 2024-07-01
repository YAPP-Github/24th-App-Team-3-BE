package org.example.repository.genre;

import java.util.List;
import java.util.UUID;
import org.example.entity.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, UUID> {

    List<Genre> findAllByIsDeletedFalse();
}
