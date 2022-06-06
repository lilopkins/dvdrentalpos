package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.FilmPagedAndSortedRepository;
import uk.hpkns.dvdrentalpos.data.repositories.FilmRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/films")
public class FilmsController {

    @Autowired
    private FilmRepository filmsRepository;
    @Autowired
    private FilmPagedAndSortedRepository filmPagedAndSortedRepository;

    public FilmsController(FilmRepository filmsRepository, FilmPagedAndSortedRepository filmPagedAndSortedRepository) {
        this.filmsRepository = filmsRepository;
        this.filmPagedAndSortedRepository = filmPagedAndSortedRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Film> getAll(Pageable p) {
        return filmPagedAndSortedRepository.findAll(p);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Film> get(@PathVariable(value = "id") int id) {
        return filmsRepository.findById(id);
    }
}
