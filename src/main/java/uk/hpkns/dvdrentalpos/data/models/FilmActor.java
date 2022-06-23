package uk.hpkns.dvdrentalpos.data.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    public FilmActor() {
        // required empty constructor for jakarta
    }

    public FilmActor(int actorId, int filmId) {
        id = new FilmActorId(actorId, filmId);
    }

    public int getActorId() {
        return id.actorId;
    }

    public int getFilmId() {
        return id.filmId;
    }

    @Embeddable
    static class FilmActorId implements Serializable {
        @Column(name = "actor_id")
        Integer actorId;
        @Column(name = "film_id")
        Integer filmId;

        public FilmActorId() {
            // required empty constructor for jakarta
        }

        public FilmActorId(Integer actorId, Integer filmId) {
            this.actorId = actorId;
            this.filmId = filmId;
        }
    }
}
