package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.data.models.Language;
import uk.hpkns.dvdrentalpos.data.repositories.LanguageRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguagesController {

    @Autowired
    private LanguageRepository languageRepository;

    public LanguagesController(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Language> getAll() {
        return languageRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Language> get(@PathVariable(value = "id") int id) {
        return languageRepository.findById(id);
    }
}
