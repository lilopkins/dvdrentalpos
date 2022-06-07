package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>, PagingAndSortingRepository<Address, Integer> {
}
