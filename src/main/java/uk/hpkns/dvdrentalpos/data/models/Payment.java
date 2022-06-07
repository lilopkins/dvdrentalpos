package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Date;

@Entity
public class Payment implements Updatable<Payment>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;
    @ManyToOne
    @JoinColumn(name = "rental_id")
    Rental rental;
    float amount;
    Date paymentDate;

    public Payment() {
        // required empty constructor
    }

    public Payment(int id, Customer customer, Staff staff, Rental rental, float amount, Date paymentDate) {
        this.id = id;
        this.customer = customer;
        this.staff = staff;
        this.rental = rental;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public Rental getRental() {
        return rental;
    }

    public float getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    @Override
    public void overlay(Payment other) {
        other.customer = this.customer;
        other.staff = this.staff;
        other.rental = this.rental;
        other.amount = this.amount;
        other.paymentDate = this.paymentDate;
    }
}
