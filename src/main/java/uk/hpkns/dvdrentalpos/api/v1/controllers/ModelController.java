package uk.hpkns.dvdrentalpos.api.v1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.api.v1.*;
import uk.hpkns.dvdrentalpos.data.Updatable;
import uk.hpkns.dvdrentalpos.data.models.auth.StaffToken;
import uk.hpkns.dvdrentalpos.data.repositories.auth.StaffTokensRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@SuppressWarnings("unused")
@CrossOrigin
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
    public @ResponseBody T createSecure(HttpServletRequest request, @RequestBody T obj) {
        AuthenticationFilter.AuthenticationResult result = (AuthenticationFilter.AuthenticationResult) request.getAttribute(AuthenticationFilter.ATTRIBUTE);
        result.intoException();
        return create(obj);
    }

    public @ResponseBody T create(T obj) {
        repository.save(obj);
        return obj;
    }

    @PutMapping("/{id}")
    public @ResponseBody T updateSecure(HttpServletRequest request, @PathVariable(value = "id") I id, @RequestBody T upd) {
        AuthenticationFilter.AuthenticationResult result = (AuthenticationFilter.AuthenticationResult) request.getAttribute(AuthenticationFilter.ATTRIBUTE);
        result.intoException();
        return update(id, upd);
    }

    public @ResponseBody T update(I id, T upd) {
        Optional<T> possiblyObj = repository.findById(id);
        if (possiblyObj.isEmpty()) throw new ResourceNotFoundException();
        T obj = possiblyObj.get();
        upd.overlay(obj);
        repository.save(obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deleteSecure(HttpServletRequest request, @PathVariable(value = "id") I id) {
        AuthenticationFilter.AuthenticationResult result = (AuthenticationFilter.AuthenticationResult) request.getAttribute(AuthenticationFilter.ATTRIBUTE);
        result.intoException();
        delete(id);
    }

    public @ResponseBody void delete(I id) {
        repository.deleteById(id);
    }
}
