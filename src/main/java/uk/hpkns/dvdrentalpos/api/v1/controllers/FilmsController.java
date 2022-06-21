package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.ResourceNotFoundException;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.FilmRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/films")
public class FilmsController extends ModelController<Film, Integer, FilmRepository> {

    private final FilmRepository repository;

    public FilmsController(FilmRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping("/{id}/actors")
    public @ResponseBody Iterable<Actor> getActors(@PathVariable(value = "id") Integer id) {
        Optional<Film> film = this.repository.findById(id);
        if (film.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return film.get().getActors();
    }
}
