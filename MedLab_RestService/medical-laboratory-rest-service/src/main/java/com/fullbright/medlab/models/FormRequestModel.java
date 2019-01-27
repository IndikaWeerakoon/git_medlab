package com.fullbright.medlab.models;

import com.fullbright.medlab.entities.TestProfile;

public class FormRequestModel {

	private TestProfile[] selectedTestProf;
	private CustomerDetailsModel customerDetails;
	private String specimenId;
	private long receiptId;
	private double totalTest;
	
	public TestProfile[] getSelectedTestProf() {
		return selectedTestProf;
	}
	public void setSelectedTestProf(TestProfile[] selectedTestProf) {
		this.selectedTestProf = selectedTestProf;
	}
	public CustomerDetailsModel getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetailsModel customerDetails) {
		this.customerDetails = customerDetails;
	}
	public String getSpecimenId() {
		return specimenId;
	}
	public void setSpecimenId(String specimenId) {
		this.specimenId = specimenId;
	}
	public long getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}
	public double getTotalTest() {
		return totalTest;
	}
	public void setTotalTest(double totalTest) {
		this.totalTest = totalTest;
	}
	
	public FormRequestModel(TestProfile[] selectedTestProf, CustomerDetailsModel customerDetails, String specimenId,
			long receiptId, double totalTest) {
		super();
		this.selectedTestProf = selectedTestProf;
		this.customerDetails = customerDetails;
		this.specimenId = specimenId;
		this.receiptId = receiptId;
		this.totalTest = totalTest;
	}
	public FormRequestModel() {
		super();
	}
	
	
}
