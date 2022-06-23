package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import uk.hpkns.dvdrentalpos.api.v1.ResourceNotFoundException;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.models.Category;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryRepository;
import uk.hpkns.dvdrentalpos.data.repositories.FilmRepository;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void testGetFilmsByCategory() {
        Film f = new Film();
        when(categoryRepository.findById(1)).thenReturn(Optional.of(new Category(1, "Test", f)));
        Iterable<Film> films = controller.getFilmsByCategory(1, Pageable.unpaged());
        assertNotNull(films);
        assertEquals(f, films.iterator().next());

        when(categoryRepository.findById(2)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> controller.getFilmsByCategory(2, null));
    }

    @Test
    public void testAddActors() {
        Actor a = new Actor();
        Set<Actor> actors = mock(Set.class);
        Film f = new Film(actors);
        when(repository.findById(1)).thenReturn(Optional.of(f));
        when(actorRepository.findById(2)).thenReturn(Optional.of(a));

        controller.addActors(1, 2);
        verify(actors).add(a);
        verify(repository).save(f);
    }

    @Test
    public void testRemoveActors() {
        Actor a = new Actor();
        Set<Actor> actors = mock(Set.class);
        Film f = new Film(actors);

        when(repository.findById(1)).thenReturn(Optional.of(f));
        when(actorRepository.findById(2)).thenReturn(Optional.of(a));

        controller.removeActors(1, 2);
        verify(actors).remove(a);
        verify(repository).save(f);
    }
}
