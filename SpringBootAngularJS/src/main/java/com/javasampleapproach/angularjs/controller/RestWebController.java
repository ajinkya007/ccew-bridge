package com.javasampleapproach.angularjs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.angularjs.service.*;
import com.javasampleapproach.angularjs.model.*;
@RestController
public class RestWebController {
	
	 @Autowired
	 LoginService service;
	 @Autowired
	 CurrentService currservice;
	 @Autowired
	 SavedService savservice;
	//List<Customer> cust = new ArrayList<Customer>();
	
	@RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
	public ArrayList<CurrentStock> getResource() throws IOException{
		System.out.println("Success3");
		//currservice=new CurrentService();
		ArrayList<CurrentStock> ar=currservice.Current();
		ar.get(0).display();
		System.out.println("Now Here");
		return ar;
	}
	
	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
	public String postCustomer(@RequestBody Customer customer){
		System.out.println("Success1");
		 if(service.validateUser(customer))
		 {
			 System.out.println("Success2");
			 return "Successful!";
		 }
			 
		 else
		 {
			 System.out.println("Fail");
			 return "failed"; 
		 }
	}
	@RequestMapping(value="/saveData", method=RequestMethod.POST)
	public String saveData(@RequestBody SavedStock ss){
		//System.out.println("Success1"+ss.getStockName());
		savservice.display(ss);
		savservice.tosave(ss);
		//savservice.toretrieve(ss);  //this is to visible in UI when saved stocks tab is clicked...to be done
		 /*call saved service*/
		return "successful";
	}
	
		/*@RequestMapping(value="/", method=RequestMethod.POST)
		public String postCustomer(@RequestBody CurrentStock currstock) throws IOException{
			System.out.println("Success3");
			 return currservice.Current();
	}*/
	@RequestMapping(value = "/getSaved", method = RequestMethod.POST)
	public ArrayList<SavedStock> retrieve(@RequestBody String uid) throws IOException{
		System.out.println("Success4");
		//currservice=new CurrentService();
		ArrayList<SavedStock> ar=savservice.toretrieve(uid);
		ar.get(0).display();
		System.out.println("Now Saved Here");
		return ar;
	}
}