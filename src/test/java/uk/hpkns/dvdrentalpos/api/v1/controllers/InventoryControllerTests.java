package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.data.models.Inventory;
import uk.hpkns.dvdrentalpos.data.repositories.InventoryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class InventoryControllerTests extends ModelControllerTests<Inventory, Integer, InventoryRepository, InventoryController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(InventoryRepository.class);
        controller = new InventoryController(repository);
    }

    @Override
    protected Class<Inventory> getTypeClass() {
        return Inventory.class;
    }

    @Override
    protected Inventory getTestObject() {
        return new Inventory(
                1,
                new FilmControllerTests().getEditObject(),
                new StoreControllerTests().getEditObject()
        );
    }

    @Override
    protected Inventory getEditObject() {
        return new Inventory(
                1,
                new FilmControllerTests().getTestObject(),
                new StoreControllerTests().getTestObject()
        );
    }

    @Override
    protected void validateChangedObject(Inventory obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertNotNull(obj.getFilm(), "film is null");
        assertNotNull(obj.getStore(), "store is null");
    }
}
