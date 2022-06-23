package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Actor;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer>, PagingAndSortingRepository<Actor, Integer> {

    List<Actor> findAllByFirstNameLikeOrLastNameLike(String queryFn, String queryLn);
}
