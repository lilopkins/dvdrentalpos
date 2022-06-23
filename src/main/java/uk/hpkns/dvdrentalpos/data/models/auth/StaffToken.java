package uk.hpkns.dvdrentalpos.data.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.models.Staff;

import java.time.LocalDateTime;

@Entity
@Table(name = "staff_tokens")
public class StaffToken {

    @Id
    int staffId;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "staff_id")
    Staff staff;
    String token;
    String validFromIp;
    LocalDateTime validUntil;

    public StaffToken() {
    }

    public StaffToken(int staffId, String token, String validFromIp, LocalDateTime validUntil) {
        this.staffId = staffId;
        this.token = token;
        this.validFromIp = validFromIp;
        this.validUntil = validUntil;
    }

    public int getStaffId() {
        return staffId;
    }

    public Staff getStaff() {
        return staff;
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
