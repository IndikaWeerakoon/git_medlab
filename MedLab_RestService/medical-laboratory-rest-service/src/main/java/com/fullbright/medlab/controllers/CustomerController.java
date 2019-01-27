package com.fullbright.medlab.controllers;

import javax.transaction.Transactional;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.fullbright.medlab.entities.Customer;
import com.fullbright.medlab.repositories.CustomerRepository;

@Component
@Path("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(Customer customer) {
		Customer newCustomer = customerRepository.save(customer);
		
		if(newCustomer != null) {
			return Response.status(Response.Status.OK).entity(newCustomer).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	@GET
	@Path("/{telephone}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("telephone") String telephone) {		
		Customer customer = customerRepository.findCustomerByTelephone(telephone);
		if(customer == null){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(customer).build();
	}	
	
}
