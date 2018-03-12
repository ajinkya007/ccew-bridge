package com.javasampleapproach.angularjs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.angularjs.model.Customer;

import com.javasampleapproach.angularjs.service.*;
@RestController
public class RestWebController {
	
	 @Autowired
	 LoginService service;
	List<Customer> cust = new ArrayList<Customer>();
	
	/*@RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
	public List<Customer> getResource(){
			return cust;
	}*/
	
	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
	public String postCustomer(@RequestBody Customer customer){
		System.out.println("Success1");
		 if(service.validateUser(customer))
		 {
			 System.out.println("Success2");
			 return "Sucessful!";
		 }
			 
		 else
		 {
			 System.out.println("Fail");
			 return "failed"; 
		 }
			
	}
}