package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Category;

public interface CategoryPagedRepository extends PagingAndSortingRepository<Category, Integer> {
}
