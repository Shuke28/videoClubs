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
@Table(name = "film_category")
public class FilmCategory {

	//film_id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="film_id")
	private Integer filmId;
	
	//category_id
	@Column(name = "category_id")
	private Integer categoryId;
	
	//last_update
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;
	
	
	//Getters and Setters
	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "FilmCategory [filmId=" + filmId + ", categoryId=" + categoryId + ", lastUpdate=" + lastUpdate
				+ ", getFilmId()=" + getFilmId() + ", getCategoryId()=" + getCategoryId() + ", getLastUpdate()="
				+ getLastUpdate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
		
	
}
