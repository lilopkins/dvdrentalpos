package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uk.hpkns.dvdrentalpos.data.models.Category;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController extends ModelController<Category, Integer, CategoryRepository> {

    private CategoryRepository repository;

    public CategoriesController(CategoryRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Category> getAll() {
        return repository.findAll();
    }
}
