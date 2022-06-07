package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.data.models.Language;

public interface LanguagePagedRepository extends PagingAndSortingRepository<Language, Integer> {
}
