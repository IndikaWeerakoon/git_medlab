package com.fullbright.medlab.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.entities.Customer;
import com.fullbright.medlab.repositories.ReceiptRepository;

@Component
@Path("/receipt")
public class ReceiptController {

	@Autowired
	ReceiptRepository receiptRepository;
	
	@GET
	@Path("/new")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNewReceiptId() {		
		String receiptId = receiptRepository.getLastReceiptId();
		
		if(receiptId == null){
			receiptId = "11110";
		}
		
		long receipt = Long.parseLong(receiptId) + 1;
		
		String response = "{\"receiptId\": \"" + receipt + "\"}";
		return Response.status(Response.Status.OK).entity(response).build();
	}	
}
