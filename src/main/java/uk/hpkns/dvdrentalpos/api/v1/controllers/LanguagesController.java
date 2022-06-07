package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Language;
import uk.hpkns.dvdrentalpos.data.repositories.LanguagePagedRepository;
import uk.hpkns.dvdrentalpos.data.repositories.LanguageRepository;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguagesController extends ModelController<Language, Integer, LanguageRepository, LanguagePagedRepository> {

    public LanguagesController(LanguageRepository repository, LanguagePagedRepository pagedRepository) {
        super(repository, pagedRepository);
    }
}
