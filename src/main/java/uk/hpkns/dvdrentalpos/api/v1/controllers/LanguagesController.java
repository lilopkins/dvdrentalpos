package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Category;
import uk.hpkns.dvdrentalpos.data.models.Language;
import uk.hpkns.dvdrentalpos.data.repositories.LanguageRepository;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguagesController extends ModelController<Language, Integer, LanguageRepository> {

    private final LanguageRepository repository;

    public LanguagesController(LanguageRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Language> getAll() {
        return repository.findAll();
    }
}
