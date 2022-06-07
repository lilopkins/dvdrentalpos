package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Address;
import uk.hpkns.dvdrentalpos.data.repositories.AddressRepository;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController extends ModelController<Address, Integer, AddressRepository> {

    public AddressController(AddressRepository repository) {
        super(repository);
    }
}
