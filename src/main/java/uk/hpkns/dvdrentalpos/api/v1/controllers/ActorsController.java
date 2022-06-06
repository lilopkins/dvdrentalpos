package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.models.Language;
import uk.hpkns.dvdrentalpos.data.repositories.ActorPagedAndSortedRepository;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;
import uk.hpkns.dvdrentalpos.data.repositories.LanguageRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorsController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private ActorPagedAndSortedRepository actorPagedAndSortedRepository;

    public ActorsController(ActorRepository actorRepository, ActorPagedAndSortedRepository actorPagedAndSortedRepository) {
        this.actorRepository = actorRepository;
        this.actorPagedAndSortedRepository = actorPagedAndSortedRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Actor> getAll(Pageable p) {
        return actorPagedAndSortedRepository.findAll(p);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Actor> get(@PathVariable(value = "id") int id) {
        return actorRepository.findById(id);
    }
}
