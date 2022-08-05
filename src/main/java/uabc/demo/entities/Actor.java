package uabc.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "actor")
public class Actor {
	
	//actor_id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="actor_id")
	private Integer actorId;
	
	//first_name
	@Column(name="first_name")
	private String firstName;
		
	//last_name
	@Column(name="last_name")
	private String lastName;
	
	//last_update
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;

	//Getters and Setters
	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actor [actorId=");
		builder.append(actorId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append("]");
		return builder.toString();
	}
	
//	@ManyToMany
//	@JoinColumn(name="actorId")
//	private List<FilmActor> filmActor;
	
	
	
}	
