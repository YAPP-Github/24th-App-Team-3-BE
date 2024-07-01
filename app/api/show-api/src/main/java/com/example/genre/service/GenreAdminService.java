package com.example.genre.service;

import com.example.genre.service.dto.request.GenreCreateServiceForm;
import com.example.genre.service.dto.request.GenreUpdateServiceForm;
import com.example.genre.service.dto.response.GenreNameServiceFormResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.genre.Genre;
import org.example.usecase.genre.GenreUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreAdminService {

    private final GenreUseCase genreUseCase;

    public void save(GenreCreateServiceForm genreCreateServiceForm) {
        genreUseCase.save(genreCreateServiceForm.toGenre());
    }


    public List<GenreNameServiceFormResponse> findAllGenres() {
        List<Genre> genres = genreUseCase.findAllGenres();
        return genres.stream()
            .map(genre -> new GenreNameServiceFormResponse(genre.getId(), genre.getName()))
            .toList();
    }

    public void updateGenre(UUID id, GenreUpdateServiceForm genreUpdateServiceForm) {
        genreUseCase.updateGenre(id, genreUpdateServiceForm.name());
    }

    public void deleteGenre(UUID id) {
        genreUseCase.deleteGenre(id);
    }

    public GenreNameServiceFormResponse findGenreById(UUID id) {
        Genre genre = genreUseCase.findGenreById(id);
        return new GenreNameServiceFormResponse(genre.getId(), genre.getName());
    }
}
