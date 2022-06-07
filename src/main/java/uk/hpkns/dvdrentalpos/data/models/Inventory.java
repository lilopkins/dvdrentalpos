package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Inventory implements Updatable<Inventory>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    public Inventory() {
        // required empty constructor
    }

    public Inventory(int id, Film film, Store store) {
        this.id = id;
        this.film = film;
        this.store = store;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public Store getStore() {
        return store;
    }

    @Override
    public void overlay(Inventory other) {
        other.film = this.film;
        other.store = this.store;
    }
}
