package com.javasampleapproach.angularjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.javasampleapproach.angularjs")
public class SpringBootAngularJsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularJsApplication.class, args);
	}
}