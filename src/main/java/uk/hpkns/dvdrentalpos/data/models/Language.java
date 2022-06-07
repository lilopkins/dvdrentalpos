package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Language implements Updatable<Language> {

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

    @Override
    public void overlay(Language other) {
        other.name = this.name;
    }
}
