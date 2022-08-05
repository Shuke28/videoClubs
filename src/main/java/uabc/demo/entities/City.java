package uabc.demo.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "city")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Integer cityId;
	
	@Column(name = "city")
	private String cityName;
	
	@Column(name = "country_id")
	private Integer countryId;
	
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
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
		builder.append("City [cityId=");
		builder.append(cityId);
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append(", countryId=");
		builder.append(countryId);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append("]");
		return builder.toString();
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
