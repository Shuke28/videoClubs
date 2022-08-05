package uabc.demo.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	
	@Column(name = "address")
	private String name;
	
	@Column(name = "address2")
	private String name2;
	
	private String district = " ";
	
	@Column(name = "city_id")
	private Integer cityId;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	private String phone = " ";
	
	@Column(name="last_update")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date lastUpdate;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		builder.append("Address [addressId=");
		builder.append(addressId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", name2=");
		builder.append(name2);
		builder.append(", district=");
		builder.append(district);
		builder.append(", cityId=");
		builder.append(cityId);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
