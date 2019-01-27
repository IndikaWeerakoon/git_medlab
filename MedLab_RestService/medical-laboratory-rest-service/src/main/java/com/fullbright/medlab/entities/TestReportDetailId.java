package com.fullbright.medlab.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class TestReportDetailId implements Serializable{
		
	@Column(name = "report_id")
	private long reportId;

	@Column(name = "test_profile_id")
	private long testProfileId;

	@Column(name = "test_id")
	private long testId;

	public TestReportDetailId(long reportId, long testProfileId, long testId) {
		super();
		this.reportId = reportId;
		this.testProfileId = testProfileId;
		this.testId = testId;
	}

	public TestReportDetailId() {
		super();
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public long getTestProfileId() {
		return testProfileId;
	}

	public void setTestProfileId(long testProfileId) {
		this.testProfileId = testProfileId;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}
	
}
