package com.ScrumTeam.Proyecto.MinTic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class ProyectoMinTicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoMinTicApplication.class, args);
	}

}
