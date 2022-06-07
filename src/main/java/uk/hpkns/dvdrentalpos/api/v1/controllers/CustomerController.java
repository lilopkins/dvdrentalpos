package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Customer;
import uk.hpkns.dvdrentalpos.data.repositories.CustomerRepository;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController extends ModelController<Customer, Integer, CustomerRepository> {

    public CustomerController(CustomerRepository repository) {
        super(repository);
    }
}
