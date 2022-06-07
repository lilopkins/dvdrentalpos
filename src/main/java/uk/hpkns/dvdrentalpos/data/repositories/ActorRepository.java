package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer>, PagingAndSortingRepository<Actor, Integer> {
}
