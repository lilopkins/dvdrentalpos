package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Date;

@Entity
public class Customer implements Updatable<Customer>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Integer id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;
    String firstName;
    String lastName;
    String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
    boolean active;
    Date createDate;

    public Customer() {
        // required empty constructor
    }

    public Customer(int id, Store store, String firstName, String lastName, String email, Address address, boolean active, Date createDate) {
        this.id = id;
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.active = active;
        this.createDate = createDate;
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

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isActive() {
        return active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void overlay(Customer other) {
        other.firstName = this.firstName;
        other.lastName = this.lastName;
        other.email = this.email;
        other.address = this.address;
        other.active = this.active;
        other.createDate = this.createDate;
    }
}
