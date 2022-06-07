package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.ActorsController;
import uk.hpkns.dvdrentalpos.api.v1.controllers.FilmsController;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;
import uk.hpkns.dvdrentalpos.data.repositories.FilmRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

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
}
