package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.LanguagesController;
import uk.hpkns.dvdrentalpos.data.models.Language;
import uk.hpkns.dvdrentalpos.data.repositories.LanguageRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LanguagesControllerTests extends ModelControllerTests<Language, Integer, LanguageRepository, LanguagesController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(LanguageRepository.class);
        controller = new LanguagesController(repository);
    }

    @Override
    protected Class<Language> getTypeClass() {
        return Language.class;
    }

    @Override
    protected Language getTestObject() {
        return new Language(
                1,
                "Swedish"
        );
    }

    @Override
    protected Language getEditObject() {
        return new Language(
                0,
                "English"
        );
    }

    @Override
    protected void validateChangedObject(Language obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("English", obj.getName(), "language incorrect");
    }
}
