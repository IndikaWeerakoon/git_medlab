package com.fullbright.medlab.controllers;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.entities.CollectionCenter;
import com.fullbright.medlab.entities.Customer;
import com.fullbright.medlab.repositories.LocationRespository;

@Component
@Path("/location")
public class CollectionCenterController {

	@Autowired
	LocationRespository locationRepository;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {		
		ArrayList<CollectionCenter> locationList = (ArrayList<CollectionCenter>) locationRepository.findAll();
		if(locationList == null){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(locationList).build();
	}	
}
