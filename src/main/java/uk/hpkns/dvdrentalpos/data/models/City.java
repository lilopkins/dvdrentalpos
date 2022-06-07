package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class City implements Updatable<City>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    String city;
    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    public City() {
        // required empty constructor
    }

    public City(int id, String city) {
        this.id = id;
        this.city = city;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }


    @Override
    public void overlay(City other) {
        other.city = this.city;
        other.country = this.country;
    }
}
