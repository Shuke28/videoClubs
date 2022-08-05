package uabc.demo.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@NamedNativeQuery(name = "Film.obtenerPeliculas",
			  query = "select f.film_id , f.title , (select c.name as category  from category c, film_category fc where c.category_id=fc.category_id  and fc.film_id=f.film_id limit 1) ,  (select count(*) as copies from inventory i where i.film_id=f.film_id group by i.film_id)  from film f",
			  resultSetMapping = "Mapping.CatalogoIndex")
@SqlResultSetMapping(name = "Mapping.CatalogoIndex",
				 classes = @ConstructorResult(targetClass = CatalogoIndex.class,
						 					  columns = {@ColumnResult(name = "film_id", type = Integer.class),
						 							  	 @ColumnResult(name = "title", type = String.class),
						 							  	 @ColumnResult(name = "category", type = String.class),
						 							  	@ColumnResult(name = "copies", type = Integer.class)}))

@NamedNativeQuery(name = "Film.filtrarPeliculasTitulo",
query = "select f.film_id , f.title , (select c.\"name\" as category  from category c, film_category fc where c.category_id=fc.category_id  and fc.film_id=f.film_id limit 1) ,  (select count(*) as copies from inventory i where i.film_id=f.film_id group by i.film_id)  from film f where UPPER(f.title) like (?)",
resultSetMapping = "Mapping.FiltrarTitulo")
@SqlResultSetMapping(name = "Mapping.FiltrarTitulo",
classes = @ConstructorResult(targetClass = CatalogoIndex.class,
		 					  columns = {@ColumnResult(name = "film_id", type = Integer.class),
		 							  	 @ColumnResult(name = "title", type = String.class),
		 							  	 @ColumnResult(name = "category", type = String.class),
		 							  	@ColumnResult(name = "copies", type = Integer.class)}))

@NamedNativeQuery(name = "Film.filtrarPeliculasCategoria",
query = "select * from (select f.film_id , f.title , (select c.\"name\" from category c, film_category fc where c.category_id=fc.category_id  and fc.film_id=f.film_id limit 1) as category ,  (select count(*) as copies from inventory i where i.film_id=f.film_id group by i.film_id)  from film f) as catalogo where catalogo.category=?",
resultSetMapping = "Mapping.FiltrarCategoria")
@SqlResultSetMapping(name = "Mapping.FiltrarCategoria",
classes = @ConstructorResult(targetClass = CatalogoIndex.class,
		 					  columns = {@ColumnResult(name = "film_id", type = Integer.class),
		 							  	 @ColumnResult(name = "title", type = String.class),
		 							  	 @ColumnResult(name = "category", type = String.class),
		 							  	@ColumnResult(name = "copies", type = Integer.class)}))

@NamedNativeQuery(name = "Film.filtrarPeliculasActor",
query = "select f.film_id, f.title, (select c.\"name\" as category  from category c, film_category fc where c.category_id=fc.category_id  and fc.film_id=f.film_id limit 1), (select count(*) as copies from inventory i where i.film_id=f.film_id group by i.film_id) from film f, film_actor fa, actor a where UPPER(concat(a.first_name,' ', a.last_name)) like(?) and f.film_id=fa.film_id and a.actor_id=fa.actor_id",
resultSetMapping = "Mapping.FiltrarActor")
@SqlResultSetMapping(name = "Mapping.FiltrarActor",
classes = @ConstructorResult(targetClass = CatalogoIndex.class,
		 					  columns = {@ColumnResult(name = "film_id", type = Integer.class),
		 							  	 @ColumnResult(name = "title", type = String.class),
		 							  	 @ColumnResult(name = "category", type = String.class),
		 							  	@ColumnResult(name = "copies", type = Integer.class)}))

@Entity
@Table(name = "film")
public class Film {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "film_id")
private Integer filmId;

private String title;

private String description;

@Column(name = "rental_duration")
private Short rentalDuration;

@Column(name = "rental_rate")
private BigDecimal rentalRate;

private Short length;

@Column(name = "replacement_cost")
private BigDecimal replacementCost;

@DateTimeFormat(pattern="MM/dd/yyyy")
private java.sql.Timestamp last_update;

@ManyToOne
@JoinColumn(name="language_id")
private Language language;

@OneToOne
@JoinColumn(name="film_id")
private Inventory inventory;

//@ManyToMany
//@JoinColumn(name="filmId")
//private List<FilmActor> filmActor;

//private String rating;

//private Date release_year;

public Integer getFilmId() {
	return filmId;
}

public void setFilmId(Integer filmId) {
	this.filmId = filmId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Short getRentalDuration() {
	return rentalDuration;
}

public void setRentalDuration(Short rentalDuration) {
	this.rentalDuration = rentalDuration;
}

public BigDecimal getRentalRate() {
	return rentalRate;
}

public void setRentalRate(BigDecimal rentalRate) {
	this.rentalRate = rentalRate;
}

public Short getLength() {
	return length;
}

public void setLength(Short length) {
	this.length = length;
}

public BigDecimal getReplacementCost() {
	return replacementCost;
}

public void setReplacementCost(BigDecimal replacementCost) {
	this.replacementCost = replacementCost;
}

public java.sql.Timestamp getLast_update() {
	return last_update;
}

public void setLast_update(java.sql.Timestamp last_update) {
	this.last_update = last_update;
}


public Language getLanguage() {
	return language;
}

public void setLanguage(Language language) {
	this.language = language;
}

//public String getRating() {
//	return rating;
//}
//
//public void setRating(String rating) {
//	this.rating = rating;
//}

@Override
public String toString() {
	return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", rentalDuration="
			+ rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost="
			+ replacementCost + ", last_update=" + last_update + ", language=" + language + "]";
}

}
