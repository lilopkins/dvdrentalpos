package uk.hpkns.dvdrentalpos.data.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.models.Customer;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_tokens")
public class CustomerToken {

    @Id
    int customerId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    String token;
    String validFromIp;
    LocalDateTime validUntil;

    public CustomerToken() {
    }

    public CustomerToken(int customerId, String token, String validFromIp, LocalDateTime validUntil) {
        this.customerId = customerId;
        this.token = token;
        this.validFromIp = validFromIp;
        this.validUntil = validUntil;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getToken() {
        return token;
    }

    public String getValidFromIp() {
        return validFromIp;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }
}
