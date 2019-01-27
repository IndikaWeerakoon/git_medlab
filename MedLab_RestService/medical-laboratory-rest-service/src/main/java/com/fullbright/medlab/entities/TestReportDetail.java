package com.fullbright.medlab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "test_report_detail")
public class TestReportDetail {

	@EmbeddedId
	private TestReportDetailId testReportDetailId;
	
	@Column(name = "value")
	private double value;
	
	@Column(name = "test_status")
	private boolean testStatus;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime;
	
	@Column(name = "comment")
	private String comment;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isTestStatus() {
		return testStatus;
	}

	public void setTestStatus(boolean testStatus) {
		this.testStatus = testStatus;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public TestReportDetailId getTestReportDetailId() {
		return testReportDetailId;
	}

	public void setTestReportDetailId(TestReportDetailId testReportDetailId) {
		this.testReportDetailId = testReportDetailId;
	}

	public TestReportDetail(TestReportDetailId testReportDetailId, double value, boolean testStatus, Date startTime,
			Date endTime, String comment) {
		super();
		this.testReportDetailId = testReportDetailId;
		this.value = value;
		this.testStatus = testStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.comment = comment;
	}
	
	public TestReportDetail(TestReportDetailId testReportDetailId, boolean testStatus, Date startTime) {
		super();
		this.testReportDetailId = testReportDetailId;
		this.value = value;
		this.testStatus = testStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.comment = comment;
	}
	
	public TestReportDetail() {
		super();
	}
	
}
