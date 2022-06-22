package uk.hpkns.dvdrentalpos.data.models.auth;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_logins")
public class CustomerLogin {

    @Id
    int customerId;
    String username;
    String passwordHash;

    public CustomerLogin() {
    }

    public CustomerLogin(int customerId, String username, String passwordHash) {
        this.customerId = customerId;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
