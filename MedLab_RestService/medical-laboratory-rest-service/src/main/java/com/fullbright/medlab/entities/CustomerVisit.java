package com.fullbright.medlab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_visit")
public class CustomerVisit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "customer_visit_id")
	private long customerVisitId;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "collection_center_id")
	private long collectionCenter;

	public long getCustomerVisitId() {
		return customerVisitId;
	}

	public void setCustomerVisitId(long customerVisitId) {
		this.customerVisitId = customerVisitId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getCollectionCenter() {
		return collectionCenter;
	}

	public void setCollectionCenter(long collectionCenter) {
		this.collectionCenter = collectionCenter;
	}

	public CustomerVisit(long customerVisitId, Date time, long customerId, long collectionCenter) {
		super();
		this.customerVisitId = customerVisitId;
		this.time = time;
		this.customerId = customerId;
		this.collectionCenter = collectionCenter;
	}
	
	public CustomerVisit(Date time, long customerId, long collectionCenter) {
		super();
		this.time = time;
		this.customerId = customerId;
		this.collectionCenter = collectionCenter;
	}

	public CustomerVisit() {
		super();
	}
	
}
