package com.fullbright.medlab.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerDetailsModel {

	
	private long customerId;
	private String tpNo;
	private String name;
	private String email;
	private String gender;
	private Date dateOfBirth;
	private long location;
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getTpNo() {
		return tpNo;
	}
	public void setTpNo(String tp) {
		this.tpNo = tp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dob) {
		this.dateOfBirth = dob;
	}
	public long getLocation() {
		return location;
	}
	public void setLocation(long location) {
		this.location = location;
	}
	public CustomerDetailsModel(long customerId, String tp, String name, String email, String gender, Date dob,
			long location) {
		super();
		this.customerId = customerId;
		this.tpNo = tp;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dob;
		this.location = location;
	}
	
	public CustomerDetailsModel() {
		super();
	}
}
