package com.developers.projectA4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.developers.projectA4")
@SpringBootApplication
public class ProjectA4Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectA4Application.class, args);
	}
}
