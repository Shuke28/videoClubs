package uabc.demo.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "film_actor")
public class FilmActor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "actor_id")
	private Integer actorId;
	
	@Column(name = "film_id")
	private Integer filmId;
	
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "FilmActor [actorId=" + actorId + ", filmId=" + filmId + ", lastUpdate=" + lastUpdate + ", getActorId()="
				+ getActorId() + ", getFilmId()=" + getFilmId() + ", getLastUpdate()=" + getLastUpdate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public FilmActor() {
		super();
	}

	public FilmActor(Integer actorId, Integer filmId, Date lastUpdate) {
		super();
		this.actorId = actorId;
		this.filmId = filmId;
		this.lastUpdate = lastUpdate;
	}
	
	
	
	
}