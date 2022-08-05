package uabc.demo.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Multa {
	
	private Integer paymentId;

	private Integer customerId;
	
	private Integer staffId;
	
	private Integer rentalId;
	
	private Integer amount;
	
	private Date paymentedate;
	
	
	//Getters and Setters
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getPaymentedate() {
		return paymentedate;
	}

	public void setPaymentedate(Date paymentedate) {
		this.paymentedate = paymentedate;
	}
	
}
