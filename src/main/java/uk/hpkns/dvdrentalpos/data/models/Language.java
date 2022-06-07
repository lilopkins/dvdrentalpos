package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

@Entity
public class Language implements Updatable<Language>, HasIdentity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer languageId;
    String name;

    public Language() {
        // required empty constructor for jakarta
    }

    public Language(int id, String name) {
        this.languageId = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
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
