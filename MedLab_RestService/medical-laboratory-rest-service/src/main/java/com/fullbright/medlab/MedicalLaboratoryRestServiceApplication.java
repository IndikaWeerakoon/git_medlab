package com.fullbright.medlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.fullbright.medlab")
@SpringBootApplication
public class MedicalLaboratoryRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalLaboratoryRestServiceApplication.class, args);
	}

}

