package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.StoreController;
import uk.hpkns.dvdrentalpos.data.models.Store;
import uk.hpkns.dvdrentalpos.data.repositories.StoreRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class StoreControllerTests extends ModelControllerTests<Store, Integer, StoreRepository, StoreController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(StoreRepository.class);
        controller = new StoreController(repository);
    }

    @Override
    protected Class<Store> getTypeClass() {
        return Store.class;
    }

    @Override
    protected Store getTestObject() {
        return new Store(
                1,
                new StaffControllerTests().getEditObject(),
                new AddressControllerTests().getEditObject()
        );
    }

    @Override
    protected Store getEditObject() {
        return new Store(
                0,
                new StaffControllerTests().getTestObject(),
                new AddressControllerTests().getTestObject()
        );
    }

    @Override
    protected void validateChangedObject(Store obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertNotNull(obj.getManager(), "manager not null");
        assertNotNull(obj.getAddress(), "address not null");
    }
}
