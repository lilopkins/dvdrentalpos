package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.repositories.ActorPagedRepository;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorsController extends ModelController<Actor, Integer, ActorRepository, ActorPagedRepository> {

    public ActorsController(ActorRepository repository, ActorPagedRepository pagedRepository) {
        super(repository, pagedRepository);
    }
}
