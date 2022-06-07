package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Date;

@Entity
public class Rental implements Updatable<Rental> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    Date rentalDate;
    // Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    Date returnDate;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;

    public Rental() {
    }

    public int getId() {
        return id;
    }

    public Date getRentalDate() {
        return rentalDate;
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
        other.customer = this.customer;
        other.returnDate = this.returnDate;
        other.staff = this.staff;
    }
}
