package com.fullbright.medlab.controllers;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.repositories.ReportRepository;

@Component
@Path("report")
public class ReportController {

	@Autowired
	ReportRepository reportRepository;
	
}
