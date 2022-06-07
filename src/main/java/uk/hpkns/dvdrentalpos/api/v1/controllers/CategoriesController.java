package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Category;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryPagedRepository;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController extends ModelController<Category, Integer, CategoryRepository, CategoryPagedRepository> {

    public CategoriesController(CategoryRepository repository, CategoryPagedRepository pagedRepository) {
        super(repository, pagedRepository);
    }
}
