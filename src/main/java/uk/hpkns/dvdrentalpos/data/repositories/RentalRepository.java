package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Rental;

public interface RentalRepository extends CrudRepository<Rental, Integer>, PagingAndSortingRepository<Rental, Integer> {
}
