package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Inventory;
import uk.hpkns.dvdrentalpos.data.repositories.InventoryRepository;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController extends ModelController<Inventory, Integer, InventoryRepository> {

    public InventoryController(InventoryRepository repository) {
        super(repository);
    }
}
