package uk.hpkns.dvdrentalpos.api.v1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uk.hpkns.dvdrentalpos.api.v1.AuthenticationFilter;
import uk.hpkns.dvdrentalpos.api.v1.ResourceNotFoundException;
import uk.hpkns.dvdrentalpos.data.models.Actor;
import uk.hpkns.dvdrentalpos.data.models.Category;
import uk.hpkns.dvdrentalpos.data.models.Film;
import uk.hpkns.dvdrentalpos.data.repositories.ActorRepository;
import uk.hpkns.dvdrentalpos.data.repositories.CategoryRepository;
import uk.hpkns.dvdrentalpos.data.repositories.FilmRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/films")
public class FilmsController extends ModelController<Film, Integer, FilmRepository> {

    private final FilmRepository repository;
    private final CategoryRepository categoryRepository;
    private ActorRepository actorRepository;

    public FilmsController(FilmRepository repository, CategoryRepository categoryRepository, ActorRepository actorRepository) {
        super(repository);
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.actorRepository = actorRepository;
    }

    @GetMapping("/category/{id}")
    public @ResponseBody Iterable<Film> getFilmsByCategory(@PathVariable(value = "id") Integer categoryId, Pageable p) {
        Optional<Category> cate = categoryRepository.findById(categoryId);
        if (cate.isEmpty())
            throw new ResourceNotFoundException();
        Set<Film> films = cate.get().getFilms();
        return new PageImpl<>(films.stream().toList(), p, films.size());
    }

    @GetMapping("/{id}/actors")
    public @ResponseBody Iterable<Actor> getActors(@PathVariable(value = "id") Integer id) {
        Optional<Film> film = this.repository.findById(id);
        if (film.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return film.get().getActors();
    }

    @PutMapping("/{id}/actors/{actor}")
    public @ResponseBody void addActorsSecure(HttpServletRequest request, @PathVariable(value = "id") Integer id, @PathVariable(value = "actor") Integer actorId) {
        AuthenticationFilter.AuthenticationResult result = (AuthenticationFilter.AuthenticationResult) request.getAttribute(AuthenticationFilter.ATTRIBUTE);
        result.intoException();
        addActors(id, actorId);
    }

    public @ResponseBody void addActors(Integer id, Integer actorId) {
        Optional<Film> filmOpt = this.repository.findById(id);
        if (filmOpt.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        Film film = filmOpt.get();
        Actor actor = actorRepository.findById(actorId).get();
        film.getActors().add(actor);
        repository.save(film);
    }

    @DeleteMapping("/{id}/actors/{actor}")
    public @ResponseBody void removeActorsSecure(HttpServletRequest request, @PathVariable(value = "id") Integer id, @PathVariable(value = "actor") Integer actorId) {
        AuthenticationFilter.AuthenticationResult result = (AuthenticationFilter.AuthenticationResult) request.getAttribute(AuthenticationFilter.ATTRIBUTE);
        result.intoException();
        removeActors(id, actorId);
    }

    public @ResponseBody void removeActors(Integer id, Integer actorId) {
        Optional<Film> filmOpt = this.repository.findById(id);
        if (filmOpt.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        Film film = filmOpt.get();
        film.getActors().remove(actorRepository.findById(actorId).get());
        repository.save(film);
    }
}
