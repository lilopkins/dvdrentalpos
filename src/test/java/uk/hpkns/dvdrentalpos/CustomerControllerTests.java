package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.CustomerController;
import uk.hpkns.dvdrentalpos.data.models.Customer;
import uk.hpkns.dvdrentalpos.data.repositories.CustomerRepository;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CustomerControllerTests extends ModelControllerTests<Customer, Integer, CustomerRepository, CustomerController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(CustomerRepository.class);
        controller = new CustomerController(repository);
    }

    @Override
    protected Class<Customer> getTypeClass() {
        return Customer.class;
    }

    @Override
    protected Customer getTestObject() {
        return new Customer(
                1,
                null,
                "Carol",
                "Davingdon",
                "kdavington@apaulmemorabilia.example.com",
                null,
                true,
                Date.from(Instant.ofEpochSecond(0x571ce))
        );
    }

    @Override
    protected Customer getEditObject() {
        return new Customer(
                1,
                null,
                "Karol",
                "Davington",
                "kdavington@apaulmemorabilia.example.com",
                null,
                true,
                Date.from(Instant.EPOCH)
        );
    }

    @Override
    protected void validateChangedObject(Customer obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("Karol", obj.getFirstName(), "first name incorrect");
        assertEquals("Davington", obj.getLastName(), "last name incorrect");
        assertEquals("kdavington@apaulmemorabilia.example.com", obj.getEmail(), "email correct");
        assertNull(obj.getAddress(), "address set");
        assertTrue(obj.isActive(), "customer not active");
        assertEquals(Date.from(Instant.EPOCH), obj.getCreateDate(), "create date correct");
    }
}
