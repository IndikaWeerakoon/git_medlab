package com.fullbright.medlab.models;

import java.util.ArrayList;

import com.fullbright.medlab.entities.Test;
import com.fullbright.medlab.entities.TestProfile;

public class ReportDataModel {

	private long reportId;
	private TestProfile testProfile;
	private ArrayList<Test> testList;
	
	public ReportDataModel(long reportId, TestProfile testProfile, ArrayList<Test> testList) {
		super();
		this.reportId = reportId;
		this.testProfile = testProfile;
		this.testList = testList;
	}
	
	public ReportDataModel() {
		super();
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public TestProfile getTestProfile() {
		return testProfile;
	}

	public void setTestProfile(TestProfile testProfile) {
		this.testProfile = testProfile;
	}

	public ArrayList<Test> getTestList() {
		return testList;
	}

	public void setTestList(ArrayList<Test> testList) {
		this.testList = testList;
	}
	
}
