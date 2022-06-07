package uk.hpkns.dvdrentalpos.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.ResourceNotFoundException;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Optional;

@SuppressWarnings("unused")
public abstract class ModelController<T extends Updatable<T>, I, R extends CrudRepository<T, I> & PagingAndSortingRepository<T, I>> {

    @Autowired
    private final R repository;

    protected ModelController(R repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<T> getPaged(Pageable p) {
        return repository.findAll(p);
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<T> get(@PathVariable(value = "id") I id) {
        return repository.findById(id);
    }

    @PutMapping("")
    public @ResponseBody T create(@RequestBody T obj) {
        repository.save(obj);
        return obj;
    }

    @PutMapping("/{id}")
    public @ResponseBody T update(@PathVariable(value = "id") I id, @RequestBody T upd) {
        Optional<T> possiblyObj = repository.findById(id);
        if (possiblyObj.isEmpty()) throw new ResourceNotFoundException();
        T obj = possiblyObj.get();
        upd.overlay(obj);
        repository.save(obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void delete(@PathVariable(value = "id") I id) {
        repository.deleteById(id);
    }
}
