package com.fullbright.medlab.controllers;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.repositories.CustomerVisitRepository;

@Component
@Path("/customervisit")
public class CustomerVisitController {

	@Autowired
	CustomerVisitRepository customerVisitRepository;
	
	
}
