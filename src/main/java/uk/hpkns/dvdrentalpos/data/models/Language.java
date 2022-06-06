package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int languageId;
    String name;

    public Language() {
        // required empty constructor for jakarta
    }

    public Language(String name) {
        this.name = name;
    }

    public int getId() {
        return languageId;
    }

    public String getName() {
        return name;
    }
}
