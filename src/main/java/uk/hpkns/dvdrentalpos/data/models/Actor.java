package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int actorId;
    String firstName;
    String lastName;

    @ManyToMany(mappedBy = "actors")
    Set<Film> films;

    public Actor() {
        // required empty constructor for jakarta
    }

    public int getId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
