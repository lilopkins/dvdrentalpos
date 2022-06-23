package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.hpkns.dvdrentalpos.api.v1.ResourceNotFoundException;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ActorsControllerTests extends ModelControllerTests<Actor, Integer, ActorRepository, ActorsController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(ActorRepository.class);
        controller = new ActorsController(repository);
    }

    @Override
    protected Class<Actor> getTypeClass() {
        return Actor.class;
    }

    @Override
    protected Actor getTestObject() {
        return new Actor(
                1,
                "Johnny",
                "Depp"
        );
    }

    @Override
    protected Actor getEditObject() {
        return new Actor(0,
                "Amber",
                "Heard"
        );
    }

    @Override
    protected void validateChangedObject(Actor obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("Amber", obj.getFirstName(), "first name incorrect");
        assertEquals("Heard", obj.getLastName(), "last name incorrect");
    }

    @Test
    public void testSearch() {
        controller.search("test");
        verify(repository).findAllByFirstNameLikeOrLastNameLike("%test%", "%test%");
    }

    @Test
    public void testGetFilms() {
        Actor a = mock(Actor.class);
        when(repository.findById(1)).thenReturn(Optional.of(a));
        controller.getFilms(1);
        verify(a).getFilms();

        assertThrows(ResourceNotFoundException.class, () -> controller.getFilms(2));
    }
}
