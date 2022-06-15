package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Set;

@Entity
public class Actor implements Updatable<Actor>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    Integer id;
    String firstName;
    String lastName;

    @ManyToMany(mappedBy = "actors")
    Set<Film> films;

    public Actor() {
        // required empty constructor for jakarta
    }

    public Actor(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Integer getId() {
        return id;
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
