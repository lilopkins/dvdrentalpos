package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Film;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer>, PagingAndSortingRepository<Film, Integer> {
}
