package com.fullbright.medlab.controllers;

import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.DefaultEditorKit.CutAction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.entities.Customer;
import com.fullbright.medlab.entities.CustomerVisit;
import com.fullbright.medlab.entities.Receipt;
import com.fullbright.medlab.entities.Report;
import com.fullbright.medlab.entities.Test;
import com.fullbright.medlab.entities.TestProfile;
import com.fullbright.medlab.entities.TestReportDetail;
import com.fullbright.medlab.entities.TestReportDetailId;
import com.fullbright.medlab.models.FormRequestModel;
import com.fullbright.medlab.models.ReportDataModel;
import com.fullbright.medlab.repositories.CustomerRepository;
import com.fullbright.medlab.repositories.CustomerVisitRepository;
import com.fullbright.medlab.repositories.ReceiptRepository;
import com.fullbright.medlab.repositories.ReportRepository;
import com.fullbright.medlab.repositories.TestProfileRepository;
import com.fullbright.medlab.repositories.TestReportDetailRepository;

@Component
@Path("/form")
public class FormController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerVisitRepository customerVisitRespository;
	
	@Autowired
	ReceiptRepository receiptRepository;
	
	@Autowired
	ReportRepository reportRepository;
	
	@Autowired
	TestReportDetailRepository testReportDetailRepository;
	
	@Autowired
	TestProfileRepository testProfileRepository;
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewReportProcess(FormRequestModel request) {
		
		Customer customer = customerRepository.findCustomerByTelephone(request.getCustomerDetails().getTpNo());
		
		if(customer == null) {
			customer = new Customer();
			customer.setDob(request.getCustomerDetails().getDateOfBirth());
			customer.setEmail(request.getCustomerDetails().getEmail());
			customer.setGender(request.getCustomerDetails().getGender());
			customer.setName(request.getCustomerDetails().getName());
			customer.setTelephone(request.getCustomerDetails().getTpNo());
			
			customerRepository.save(customer);
		}
		
		CustomerVisit customerVisit = new CustomerVisit(new Date(), customer.getCustomerId(), 
				request.getCustomerDetails().getLocation());
		customerVisitRespository.save(customerVisit);
		
		Receipt receipt = new Receipt(request.getReceiptId(), request.getTotalTest(), false, customer.getCustomerId(),
				request.getCustomerDetails().getLocation(), new Date());
		receiptRepository.save(receipt);
		
		Report report = new Report(receipt.getReceiptId(), false, null, customerVisit.getCustomerVisitId(), 
				request.getSpecimenId());
		reportRepository.save(report);
		
		ArrayList<Integer> testDet = testProfileRepository.getTestIdByProfile(request.getSelectedTestProf()[0].getProfileId());
		
		for(Integer test : testDet) {
			TestReportDetailId testReportDetailId = new TestReportDetailId(report.getReportId(),
					request.getSelectedTestProf()[0].getProfileId(), test);
			
			TestReportDetail testReportDetail = new TestReportDetail(testReportDetailId, false, new Date());
			testReportDetailRepository.save(testReportDetail);
		}		
		
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Path("/report/{specimenId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReportDetailsBySpecimenId(@PathParam("specimenId") String specimenId) {
		
		long reportId = reportRepository.getReportIdBySpecimenId(specimenId); 
		
		TestProfile testProfile = testProfileRepository.getTestProfileDetailsByReportId(reportId);
		
		ArrayList<Object[]> testDet = testProfileRepository.getTestByProfile(testProfile.getProfileId());
		
		ArrayList<Test> testList = new ArrayList<Test>();
		
		for(Object[] obj : testDet) {
			testList.add(new Test(((Integer)obj[0]), (String)obj[1], (Integer)obj[2], (String)obj[3], (String)obj[4], (String)obj[5], ((BigDecimal)obj[6]).doubleValue()));
		}
		
		ReportDataModel reportData = new ReportDataModel(reportId, testProfile, testList);
		
		return Response.status(Response.Status.OK).entity(reportData).build();
	}	

}
