package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.data.models.Address;
import uk.hpkns.dvdrentalpos.data.repositories.AddressRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class AddressControllerTests extends ModelControllerTests<Address, Integer, AddressRepository, AddressController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(AddressRepository.class);
        controller = new AddressController(repository);
    }

    @Override
    protected Class<Address> getTypeClass() {
        return Address.class;
    }

    @Override
    protected Address getTestObject() {
        return new Address(
                1,
                "1 Anywhere Drive",
                "Wolverhampton",
                "Staffordshire",
                null,
                "WV71AA",
                "01632 960975"
        );
    }

    @Override
    protected Address getEditObject() {
        return new Address(
                1,
                "13 Unlucky Road",
                "Somewhere else",
                "Staffordshire",
                null,
                "WV71AA",
                "01632 960976"
        );
    }

    @Override
    protected void validateChangedObject(Address obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("13 Unlucky Road", obj.getAddress(), "address incorrect");
        assertEquals("Somewhere else", obj.getAddress2(), "address 2 incorrect");
        assertEquals("Staffordshire", obj.getDistrict(), "district incorrect");
        assertNull(obj.getCity(), "city is set");
        assertEquals("WV71AA", obj.getPostalCode(), "postal code incorrect");
        assertEquals("01632 960976", obj.getPhone(), "phone incorrect");
    }
}
