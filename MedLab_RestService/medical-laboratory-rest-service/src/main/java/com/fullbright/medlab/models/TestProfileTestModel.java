package com.fullbright.medlab.models;

import java.util.ArrayList;

import com.fullbright.medlab.entities.Test;

public class TestProfileTestModel {

	private long testProfileId;
	private String testProfileName;
	private ArrayList<Test> testSet;
	
	public long getTestProfileId() {
		return testProfileId;
	}
	public void setTestProfileId(long testProfileId) {
		this.testProfileId = testProfileId;
	}
	public String getTestProfileName() {
		return testProfileName;
	}
	public void setTestProfileName(String testProfileName) {
		this.testProfileName = testProfileName;
	}
	public ArrayList<Test> getTestSet() {
		return testSet;
	}
	public void setTestSet(ArrayList<Test> testSet) {
		this.testSet = testSet;
	}
	
	public TestProfileTestModel(long testProfileId, String testProfileName, ArrayList<Test> testSet) {
		super();
		this.testProfileId = testProfileId;
		this.testProfileName = testProfileName;
		this.testSet = testSet;
	}
	
	public TestProfileTestModel() {
		super();
	}	
	
}
