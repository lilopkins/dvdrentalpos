package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Country;
import uk.hpkns.dvdrentalpos.data.repositories.CountryRepository;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController extends ModelController<Country, Integer, CountryRepository> {

    public CountryController(CountryRepository repository) {
        super(repository);
    }
}
