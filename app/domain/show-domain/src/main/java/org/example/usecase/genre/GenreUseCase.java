package org.example.usecase.genre;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
import org.example.error.GenreError;
import org.example.exception.BusinessException;
import org.example.repository.genre.GenreRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class GenreUseCase {

    private final GenreRepository genreRepository;

    @Transactional
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional(readOnly = true)
    public List<Genre> findAllGenres() {
        return genreRepository.findAllByIsDeletedFalse();
    }

    @Transactional
    public void updateGenre(UUID id, String name) {
        Genre genre = findGenreById(id);
        genre.updateGenre(name);
    }

    @Transactional
    public void deleteGenre(UUID id) {
        Genre genre = findGenreById(id);
        genre.updateDeleteStatus(true);
    }

    @Transactional(readOnly = true)
    public Genre findGenreById(UUID id) {
        return genreRepository.findById(id)
            .orElseThrow(() -> new BusinessException(GenreError.ENTITY_NOT_FOUND_ERROR));
    }
}
