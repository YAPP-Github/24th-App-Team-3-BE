package com.example.genre.controller;

import com.example.genre.controller.dto.request.GenreCreateApiForm;
import com.example.genre.controller.dto.request.GenreUpdateApiForm;
import com.example.genre.controller.dto.response.GenreNameApiFormResponse;
import com.example.genre.service.GenreAdminService;
import com.example.genre.service.dto.response.GenreNameServiceFormResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/genres")
public class GenreAdminController {

    private final GenreAdminService genreAdminService;

    @GetMapping
    public String createGenre() {
        return "genre_create_form";
    }

    @PostMapping
    public String createGenre(@Valid GenreCreateApiForm genreCreateApiForm) {
        genreAdminService.save(genreCreateApiForm.toGenreCreateServiceForm());
        return "redirect:/api/v1/admin/genres/list";
    }

    @GetMapping("/list")
    public String findAllGenres(Model model) {
        List<GenreNameApiFormResponse> genreNameApiFormResponses = genreAdminService.findAllGenres().stream()
            .map(response -> new GenreNameApiFormResponse(response.id(), response.name()))
            .toList();

        model.addAttribute("genres", genreNameApiFormResponses);
        return "genre_list_form";
    }

    @GetMapping("/{id}")
    public String findGenre(@PathVariable("id") UUID id, Model model) {
        GenreNameServiceFormResponse genreNameServiceFormResponse = genreAdminService.findGenreById(
            id);
        GenreNameApiFormResponse genreNameApiFormResponse = new GenreNameApiFormResponse(
            genreNameServiceFormResponse.id(),
            genreNameServiceFormResponse.name()
        );

        model.addAttribute("genre", genreNameApiFormResponse);
        return "genre_form";
    }

    @PutMapping("/{id}")
    public String updateGenre(@PathVariable("id") UUID id,
        @Valid GenreUpdateApiForm genreUpdateApiForm) {
        genreAdminService.updateGenre(id, genreUpdateApiForm.toGenreUpdateServiceForm());
        return "redirect:/api/v1/admin/genres/list";
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable("id") UUID id) {
        genreAdminService.deleteGenre(id);
        return "redirect:/api/v1/admin/genres/list";
    }
}
