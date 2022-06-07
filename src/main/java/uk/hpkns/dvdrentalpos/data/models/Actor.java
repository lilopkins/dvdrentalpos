package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Set;

@Entity
public class Actor implements Updatable<Actor>, HasIdentity<Integer> {

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

    public Actor(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Integer getId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public void overlay(Actor other) {
        other.firstName = this.firstName;
        other.lastName = this.lastName;
    }
}
