package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Film;

public interface FilmPagedRepository extends PagingAndSortingRepository<Film, Integer> {
}
