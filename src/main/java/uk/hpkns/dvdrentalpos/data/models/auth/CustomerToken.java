package uk.hpkns.dvdrentalpos.data.models.auth;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_tokens")
public class CustomerToken {

    @Id
    int customerId;
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
