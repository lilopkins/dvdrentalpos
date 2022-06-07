package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Country;

public interface CountryRepository extends CrudRepository<Country, Integer>, PagingAndSortingRepository<Country, Integer> {
}
