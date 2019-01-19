package com.fullbright.medlab.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.controllers.CustomerController;
import com.fullbright.medlab.controllers.UserController;

@ApplicationPath("/medlab")
@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(CustomerController.class);
		register(UserController.class);
	}
}
