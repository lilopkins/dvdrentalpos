package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Rental;
import uk.hpkns.dvdrentalpos.data.repositories.RentalRepository;

@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController extends ModelController<Rental, Integer, RentalRepository> {

    public RentalController(RentalRepository repository) {
        super(repository);
    }
}
