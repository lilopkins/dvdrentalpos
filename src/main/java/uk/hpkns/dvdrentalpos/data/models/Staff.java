package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Staff implements Updatable<Staff>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    String firstName;
    String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
    byte[] picture;
    String email;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
    boolean active;
    String username;
    String password;

    public Staff() {
        // required empty constructor
    }

    public Staff(int id, String firstName, String lastName, Address address, byte[] picture, String email, Store store, boolean active, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.picture = picture;
        this.email = email;
        this.store = store;
        this.active = active;
        this.username = username;
        this.password = password;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public Store getStore() {
        return store;
    }

    public boolean isActive() {
        return active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void overlay(Staff other) {
        other.firstName = this.firstName;
        other.lastName = this.lastName;
        other.address = this.address;
        other.picture = this.picture;
        other.email = this.email;
        other.store = this.store;
        other.active = this.active;
        other.username = this.username;
        other.password = this.password;
    }
}
