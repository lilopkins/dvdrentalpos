package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.data.models.City;
import uk.hpkns.dvdrentalpos.data.repositories.CityRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class CitiesControllerTests extends ModelControllerTests<City, Integer, CityRepository, CityController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(CityRepository.class);
        controller = new CityController(repository);
    }

    @Override
    protected Class<City> getTypeClass() {
        return City.class;
    }

    @Override
    protected City getTestObject() {
        return new City(
                1,
                "Birmingham"
        );
    }

    @Override
    protected City getEditObject() {
        return new City(
                0,
                "Wolverhampton"
        );
    }

    @Override
    protected void validateChangedObject(City obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("Wolverhampton", obj.getCity(), "city name incorrect");
        assertNull(obj.getCountry(), "country is set");
    }
}
