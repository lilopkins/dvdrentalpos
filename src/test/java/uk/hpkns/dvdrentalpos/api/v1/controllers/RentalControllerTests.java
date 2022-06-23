package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.data.models.Rental;
import uk.hpkns.dvdrentalpos.data.repositories.RentalRepository;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class RentalControllerTests extends ModelControllerTests<Rental, Integer, RentalRepository, RentalController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(RentalRepository.class);
        controller = new RentalController(repository);
    }

    @Override
    protected Class<Rental> getTypeClass() {
        return Rental.class;
    }

    @Override
    protected Rental getTestObject() {
        return new Rental(
                1,
                Date.from(Instant.EPOCH),
                null,
                null,
                Date.from(Instant.ofEpochSecond(30)),
                null
        );
    }

    @Override
    protected Rental getEditObject() {
        return new Rental(
                0,
                Date.from(Instant.ofEpochSecond(1)),
                null,
                null,
                Date.from(Instant.ofEpochSecond(34)),
                null
        );
    }

    @Override
    protected void validateChangedObject(Rental obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals(Date.from(Instant.ofEpochSecond(1)), obj.getRentalDate(), "rental date incorrect");
        assertNull(obj.getInventory(), "inventory is set");
        assertNull(obj.getCustomer(), "customer is set");
        assertNull(obj.getStaff(), "staff is set");
        assertEquals(Date.from(Instant.ofEpochSecond(34)), obj.getReturnDate(), "return date incorrect");
    }
}
