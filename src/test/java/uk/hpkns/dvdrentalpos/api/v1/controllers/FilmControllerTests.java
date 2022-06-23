package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryRepository;
import uk.hpkns.dvdrentalpos.data.repositories.FilmRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class FilmControllerTests extends ModelControllerTests<Film, Integer, FilmRepository, FilmsController> {

    private CategoryRepository categoryRepository;
    private ActorRepository actorRepository;

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        actorRepository = mock(ActorRepository.class);
        controller = new FilmsController(repository, categoryRepository, actorRepository);
    }

    @Override
    protected Class<Film> getTypeClass() {
        return Film.class;
    }

    @Override
    protected Film getTestObject() {
        return new Film(1,
                "Airplane!",
                "A man afraid to fly must ensure that a plane lands safely after the pilots become sick.",
                1980,
                null,
                null,
                7,
                1.99f,
                88,
                4.99f,
                "PG",
                ""
        );
    }

    @Override
    protected Film getEditObject() {
        return new Film(0,
                "Aeroplane!",
                "A man afraid to fly must ensure that a plane lands safely after the pilots become sick. Shirley you can't be serious!",
                1980,
                null,
                null,
                7,
                1.99f,
                88,
                4.99f,
                "PG",
                ""
        );
    }

    @Override
    protected void validateChangedObject(Film obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("Aeroplane!", obj.getTitle(), "title incorrect");
        assertEquals("A man afraid to fly must ensure that a plane lands safely after the pilots become sick. Shirley you can't be serious!", obj.getDescription(), "description incorrect");
        assertEquals(1980, obj.getReleaseYear(), "release year incorrect");
        assertNull(obj.getLanguage(), "language incorrect");
        assertNull(obj.getOriginalLanguage(), "original language incorrect");
        assertEquals(7, obj.getRentalDuration(), "rental duration incorrect");
        assertEquals(1.99f, obj.getRentalRate(), "rental rate incorrect");
        assertEquals(88, obj.getLength(), "length incorrect");
        assertEquals(4.99f, obj.getReplacementCost(), "replacement cost incorrect");
        assertEquals("PG", obj.getRating(), "rating incorrect");
        assertEquals("", obj.getSpecialFeatures(), "special features incorrect");
    }
}
