package com.fullbright.medlab.controllers;

import java.applet.AppletContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.repositories.TestReportDetailRepository;

@Component
@Path("/testreport")
public class TestReportDetailController {

	@Autowired
	TestReportDetailRepository testReportDetailRepository;
	
//	@GET
//	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response get() {
//		return Response.status(Response.Status.ACCEPTED).entity(testReportDetailRepository.findAll()).build();
//	}
}
