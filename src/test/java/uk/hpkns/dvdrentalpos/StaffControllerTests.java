package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.StaffController;
import uk.hpkns.dvdrentalpos.data.models.Staff;
import uk.hpkns.dvdrentalpos.data.repositories.StaffRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class StaffControllerTests extends ModelControllerTests<Staff, Integer, StaffRepository, StaffController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(StaffRepository.class);
        controller = new StaffController(repository);
    }

    @Override
    protected Class<Staff> getTypeClass() {
        return Staff.class;
    }

    @Override
    protected Staff getTestObject() {
        return new Staff(
                1,
                "Carol",
                "Davingdon",
                null,
                new byte[0],
                "kdavington@apaulmemorabilia.example.com",
                null,
                true,
                "kdavington",
                "password_hash"
        );
    }

    @Override
    protected Staff getEditObject() {
        return new Staff(
                0,
                "Karol",
                "Davington",
                null,
                new byte[0],
                "kdavington@apaulmemorabilia.example.com",
                null,
                true,
                "kdavington",
                "password_hash"
        );
    }

    @Override
    protected void validateChangedObject(Staff obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("Karol", obj.getFirstName(), "first name incorrect");
        assertEquals("Davington", obj.getLastName(), "last name incorrect");
        assertNull(obj.getAddress(), "address set");
        assertEquals(0, obj.getPicture().length, "picture incorrect");
        assertEquals("kdavington@apaulmemorabilia.example.com", obj.getEmail(), "email correct");
        assertNull(obj.getStore(), "store set");
        assertTrue(obj.isActive(), "should be active");
        assertEquals("kdavington", obj.getUsername(), "username incorrect");
        assertEquals("password_hash", obj.getPassword(), "password incorrect");
    }
}
