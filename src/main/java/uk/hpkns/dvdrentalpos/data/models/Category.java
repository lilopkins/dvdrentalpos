package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Category implements Updatable<Category>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    Integer id;
    String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
        // required empty constructor for jakarta
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void overlay(Category other) {
        other.name = this.name;
    }
}
