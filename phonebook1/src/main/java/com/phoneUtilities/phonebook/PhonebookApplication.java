package com.phoneUtilities.phonebook;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.phoneUtilities")
public class PhonebookApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}

}
