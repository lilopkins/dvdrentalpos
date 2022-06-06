package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.data.models.Category;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Category> get(@PathVariable(value = "id") int id) {
        return categoryRepository.findById(id);
    }
}
