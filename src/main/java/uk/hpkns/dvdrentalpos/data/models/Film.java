package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Set;

@Entity
public class Film implements Updatable<Film> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int filmId;
    String title;
    String description;
    int releaseYear;
    @OneToOne(optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    Language language;
    @OneToOne
    @JoinColumn(name = "original_language_id")
    Language originalLanguage;
    int rentalDuration;
    float rentalRate;
    int length;
    float replacementCost;
    String rating;
    String specialFeatures;

    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = {
            @JoinColumn(name = "film_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "actor_id", nullable = false)
    })
    Set<Actor> actors;

    public Film() {
        // required empty constructor for jakarta
    }

    public int getId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public float getRentalRate() {
        return rentalRate;
    }

    public int getLength() {
        return length;
    }

    public float getReplacementCost() {
        return replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    @JsonIgnore
    public Set<Actor> getActors() {
        return actors;
    }

    @Override
    public void overlay(Film other) {
        other.title = this.title;
        other.description = this.description;
        other.releaseYear = this.releaseYear;
        other.language = this.language;
        other.originalLanguage = this.originalLanguage;
        other.rentalDuration = this.rentalDuration;
        other.rentalRate = this.rentalRate;
        other.length = this.length;
        other.replacementCost = this.replacementCost;
        other.rating = this.rating;
        other.specialFeatures = this.specialFeatures;
    }
}
