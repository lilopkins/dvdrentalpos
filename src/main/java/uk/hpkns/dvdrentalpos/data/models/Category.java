package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Category implements Updatable<Category>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer categoryId;
    String name;

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category() {
        // required empty constructor for jakarta
    }

    @Override
    public Integer getId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    @Override
    public void overlay(Category other) {
        other.name = this.name;
    }
}
