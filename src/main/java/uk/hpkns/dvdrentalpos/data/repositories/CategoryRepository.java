package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.hpkns.dvdrentalpos.data.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
