package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.City;

public interface CityRepository extends CrudRepository<City, Integer>, PagingAndSortingRepository<City, Integer> {
}
