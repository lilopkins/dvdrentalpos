package uk.hpkns.dvdrentalpos.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Set;

@Entity
public class Category implements Updatable<Category>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    Integer id;
    String name;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "film_category", joinColumns = {
            @JoinColumn(name = "category_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "film_id", nullable = false)
    })
    Set<Film> films;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name, Film... films) {
        this.id = id;
        this.name = name;
        this.films = Set.of(films);
    }

    public Category() {
        // required empty constructor for jakarta
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    @Override
    public void overlay(Category other) {
        other.name = this.name;
    }
}
