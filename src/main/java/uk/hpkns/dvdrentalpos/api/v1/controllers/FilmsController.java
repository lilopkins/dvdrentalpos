package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.FilmRepository;

@RestController
@RequestMapping("/api/v1/films")
public class FilmsController extends ModelController<Film, Integer, FilmRepository> {

    public FilmsController(FilmRepository repository) {
        super(repository);
    }
}
