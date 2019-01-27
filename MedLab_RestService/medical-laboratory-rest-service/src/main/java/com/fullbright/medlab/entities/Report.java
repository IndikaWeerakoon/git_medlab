package com.fullbright.medlab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "report_id")
	private long reportId;
	
	@Column(name = "receipt_id")
	private long receiptId;
	
	@Column(name = "is_completed")
	private boolean isCompleted;
	
	@Column(name = "issued_date")
	private Date issuedDate;
	
	@Column(name = "customer_visit_id")
	private long customerVisitId;
	
	@Column(name = "specimen_id")
	private String specimenId;

	public Report(long reportId, long receiptId, boolean isCompleted, Date issuedDate, long customerVisitId,
			String specimenId) {
		super();
		this.reportId = reportId;
		this.receiptId = receiptId;
		this.isCompleted = isCompleted;
		this.issuedDate = issuedDate;
		this.customerVisitId = customerVisitId;
		this.specimenId = specimenId;
	}
	
	public Report(long receiptId, boolean isCompleted, Date issuedDate, long customerVisitId,
			String specimenId) {
		super();
		this.receiptId = receiptId;
		this.isCompleted = isCompleted;
		this.issuedDate = issuedDate;
		this.customerVisitId = customerVisitId;
		this.specimenId = specimenId;
	}
	
	public Report() {
		super();
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public long getCustomerVisitId() {
		return customerVisitId;
	}

	public void setCustomerVisitId(long customerVisitId) {
		this.customerVisitId = customerVisitId;
	}

	public String getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(String specimenId) {
		this.specimenId = specimenId;
	}	
	
}
