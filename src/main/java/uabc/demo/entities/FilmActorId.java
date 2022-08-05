/*
package uabc.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FilmActorId implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "film_id")
    private Integer filmId;
    
    @Column(name = "actor_id")
    private Integer actorId;

    public FilmActorId(){
    }
    
    public FilmActorId(Integer filmId, Integer actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId filmCategoryId = (FilmActorId) o;
        return filmId.equals(filmCategoryId.filmId) &&
                actorId.equals(filmCategoryId.actorId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(filmId, actorId);
    }

}
*/