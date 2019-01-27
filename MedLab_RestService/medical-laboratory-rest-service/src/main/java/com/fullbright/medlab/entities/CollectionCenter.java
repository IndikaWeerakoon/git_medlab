package com.fullbright.medlab.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collection_center")
public class CollectionCenter {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "collection_center_id")
	private long locationId;
	
	@Column(name = "location")
	private String location;

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CollectionCenter(long locationId, String location) {
		super();
		this.locationId = locationId;
		this.location = location;
	}
	
	public CollectionCenter() {
		super();
	}
	
}
