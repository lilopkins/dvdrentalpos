package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer>, PagingAndSortingRepository<Inventory, Integer> {
}
