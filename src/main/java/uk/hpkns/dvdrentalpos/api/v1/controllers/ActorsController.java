package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.api.v1.ResourceNotFoundException;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorsController extends ModelController<Actor, Integer, ActorRepository> {

    private final ActorRepository repository;

    public ActorsController(ActorRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping("/{id}/films")
    public @ResponseBody Iterable<Film> getFilms(@PathVariable(value = "id") Integer id) {
        Optional<Actor> actor = this.repository.findById(id);
        if (actor.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return actor.get().getFilms();
    }
}
