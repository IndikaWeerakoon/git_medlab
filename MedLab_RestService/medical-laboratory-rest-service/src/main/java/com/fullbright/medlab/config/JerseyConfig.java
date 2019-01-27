package com.fullbright.medlab.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fullbright.medlab.controllers.CustomerController;
import com.fullbright.medlab.controllers.TestController;
import com.fullbright.medlab.controllers.TestProfileController;
import com.fullbright.medlab.controllers.UserController;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(CustomerController.class);
		register(UserController.class);
		register(TestProfileController.class);
		register(TestController.class);
	}
}
