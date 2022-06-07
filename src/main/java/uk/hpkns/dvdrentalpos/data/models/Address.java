package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Address implements Updatable<Address> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    String address;
    String address2;
    String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;
    String postalCode;
    String phone;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getDistrict() {
        return district;
    }

    public City getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }


    @Override
    public void overlay(Address other) {
        other.address = this.address;
        other.address2 = this.address2;
        other.district = this.district;
        other.city = this.city;
        other.postalCode = this.postalCode;
        other.phone = this.phone;
    }
}
