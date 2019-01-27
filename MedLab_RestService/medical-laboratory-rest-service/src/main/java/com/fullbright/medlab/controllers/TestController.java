package com.fullbright.medlab.controllers;

import java.util.ArrayList;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.entities.Test;
import com.fullbright.medlab.repositories.TestRepository;

@Component
@Path("/test")
public class TestController {

	@Autowired
	private TestRepository testRepository;
	
	public ArrayList<Test> getTestFromProfileId(long profileId){
		return testRepository.getTestByProfile(profileId);
	}
	
}
