package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.City;
import uk.hpkns.dvdrentalpos.data.repositories.CityRepository;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController extends ModelController<City, Integer, CityRepository> {

    public CityController(CityRepository repository) {
        super(repository);
    }
}
