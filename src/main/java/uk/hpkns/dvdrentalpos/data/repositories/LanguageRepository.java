package uk.hpkns.dvdrentalpos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.hpkns.dvdrentalpos.data.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
}
