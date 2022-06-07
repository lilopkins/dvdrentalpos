package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.BeforeEach;
import uk.hpkns.dvdrentalpos.api.v1.controllers.CategoriesController;
import uk.hpkns.dvdrentalpos.data.models.Category;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CategoriesControllerTests extends ModelControllerTests<Category, Integer, CategoryRepository, CategoriesController> {

    @Override
    @BeforeEach
    public void setup() {
        repository = mock(CategoryRepository.class);
        controller = new CategoriesController(repository);
    }

    @Override
    protected Class<Category> getTypeClass() {
        return Category.class;
    }

    @Override
    protected Category getTestObject() {
        return new Category(
                1,
                "Documentary"
        );
    }

    @Override
    protected Category getEditObject() {
        return new Category(
                0,
                "Docudrama"
        );
    }

    @Override
    protected void validateChangedObject(Category obj) {
        assertEquals(1, obj.getId(), "id incorrect");
        assertEquals("Docudrama", obj.getName(), "category name incorrect");
    }
}
