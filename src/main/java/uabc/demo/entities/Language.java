package uabc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private Integer languageId;
	
	@Column(columnDefinition = "bpchar(20)", length = 20)
	private String name;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private java.sql.Timestamp last_update;
	public Integer getLanguageId() {
		return languageId;
	
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public java.sql.Timestamp getLast_update() {
		return last_update;
	}
	
	public void setLast_update(java.sql.Timestamp last_update) {
		this.last_update = last_update;
	}
	
	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", name=" + name + ", last_update=" + last_update + "]";
	}

	
}
