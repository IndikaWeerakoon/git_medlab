package com.fullbright.medlab.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "test_id")
	private Long testId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "hours")
	private int hours;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "range")
	private String range;
	
	@Column(name = "specimen_type")
	private String specimenType;
	
	@Column(name = "price")
	private double price;

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getSpecimenType() {
		return specimenType;
	}

	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Test(int testId, String name, int hours, String unit, String range, String specimenType, double price) {
		super();
		this.testId = (long) testId;
		this.name = name;
		this.hours = hours;
		this.unit = unit;
		this.range = range;
		this.specimenType = specimenType;
		this.price = price;
	}
	
	public Test() {
		super();
	}	
		
	
}
