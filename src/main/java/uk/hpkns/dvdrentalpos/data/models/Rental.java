package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Date;

@Entity
public class Rental implements Updatable<Rental>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    Date rentalDate;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    Date returnDate;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;

    public Rental() {
        // required empty constructor
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Staff getStaff() {
        return staff;
    }

    @Override
    public void overlay(Rental other) {
        other.rentalDate = this.rentalDate;
        other.inventory = inventory;
        other.customer = this.customer;
        other.returnDate = this.returnDate;
        other.staff = this.staff;
    }
}
