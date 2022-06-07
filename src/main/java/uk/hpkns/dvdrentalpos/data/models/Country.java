package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Country implements Updatable<Country>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String country;

    public Country() {
        // required empty constructor
    }

    public Country(int id, String country) {
        this.id = id;
        this.country = country;
    }

    @Override
    public Integer getId() {
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
