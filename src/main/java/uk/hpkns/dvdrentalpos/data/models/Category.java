package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int categoryId;
    String name;

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category() {
        // required empty constructor for jakarta
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
