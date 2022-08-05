package uabc.demo.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Integer countryId;
	
	@Column(name = "country")
	private String countryName;
	
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [countryId=");
		builder.append(countryId);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
