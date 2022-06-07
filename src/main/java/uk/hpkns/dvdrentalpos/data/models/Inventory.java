package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Inventory implements Updatable<Inventory> {

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

    public int getId() {
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
