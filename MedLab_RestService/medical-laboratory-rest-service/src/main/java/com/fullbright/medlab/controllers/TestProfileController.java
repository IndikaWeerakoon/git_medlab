package com.fullbright.medlab.controllers;


import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.entities.Test;
import com.fullbright.medlab.entities.TestProfile;
import com.fullbright.medlab.models.TestProfileTestModel;
import com.fullbright.medlab.repositories.TestProfileRepository;

@Component
@Path("/testprofile")
public class TestProfileController {
	
	@Autowired
	TestProfileRepository testProfileRepository;
	
	@Autowired
	TestController testController;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProfile(){
		ArrayList<TestProfile> profileList = (ArrayList<TestProfile>) testProfileRepository.findAll();
		return Response.status(Response.Status.OK).entity(profileList).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTestProfileTest(){
		
		ArrayList<TestProfileTestModel> testProfileTestList = new ArrayList<TestProfileTestModel>();
		
		ArrayList<TestProfile> profileList = (ArrayList<TestProfile>) testProfileRepository.findAll();
		
		for(TestProfile profile : profileList) {
			TestProfileTestModel testProfileTest = new TestProfileTestModel();
			
			testProfileTest.setTestProfileId(profile.getProfileId());
			testProfileTest.setTestProfileName(profile.getProfileName());
			
			ArrayList<Object[]> testDet = testProfileRepository.getTestByProfile(profile.getProfileId());
			
			ArrayList<Test> testList = new ArrayList<Test>();
			
			for(Object[] obj : testDet) {
				testList.add(new Test(((Integer)obj[0]), (String)obj[1], (Integer)obj[2], (String)obj[3], (String)obj[4], (String)obj[5], ((BigDecimal)obj[6]).doubleValue()));
			}
			
			testProfileTest.setTestSet(testList);
			testProfileTestList.add(testProfileTest);
		}
		
		return Response.status(Response.Status.OK).entity(testProfileTestList).build();
	}

}
