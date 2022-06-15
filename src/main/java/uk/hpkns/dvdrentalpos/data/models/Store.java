package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Store implements Updatable<Store>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Integer id;
    @ManyToOne
    @JoinColumn(name = "manager_staff_id")
    Staff manager;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    public Store() {
        // required empty constructor
    }

    public Store(int id, Staff manager, Address address) {
        this.id = id;
        this.manager = manager;
        this.address = address;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Staff getManager() {
        return manager;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public void overlay(Store other) {
        other.manager = this.manager;
        other.address = this.address;
    }
}
