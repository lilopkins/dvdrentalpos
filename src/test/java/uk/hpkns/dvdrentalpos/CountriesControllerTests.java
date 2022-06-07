package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.CountryController;
import uk.hpkns.dvdrentalpos.data.models.Country;
import uk.hpkns.dvdrentalpos.data.repositories.CountryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CountriesControllerTests extends ModelControllerTests<Country, Integer, CountryRepository, CountryController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(CountryRepository.class);
        controller = new CountryController(repository);
    }

    @Override
    protected Class<Country> getTypeClass() {
        return Country.class;
    }

    @Override
    protected Country getTestObject() {
        return new Country(
                1,
                "Sweden"
        );
    }

    @Override
    protected Country getEditObject() {
        return new Country(
                0,
                "The Netherlands"
        );
    }

    @Override
    protected void validateChangedObject(Country obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("The Netherlands", obj.getCountry(), "country incorrect");
    }
}
