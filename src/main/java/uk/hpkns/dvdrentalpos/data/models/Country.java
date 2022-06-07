package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Country implements Updatable<Country> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    String country;

    public Country() {
        // required empty constructor
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public void overlay(Country other) {
        other.country = this.country;
    }
}
