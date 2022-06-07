package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Store;
import uk.hpkns.dvdrentalpos.data.repositories.StoreRepository;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController extends ModelController<Store, Integer, StoreRepository> {

    public StoreController(StoreRepository repository) {
        super(repository);
    }
}
