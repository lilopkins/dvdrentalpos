package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Store;

public interface StoreRepository extends CrudRepository<Store, Integer>, PagingAndSortingRepository<Store, Integer> {
}
