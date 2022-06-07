package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Actor;

public interface ActorPagedRepository extends PagingAndSortingRepository<Actor, Integer> {
}
