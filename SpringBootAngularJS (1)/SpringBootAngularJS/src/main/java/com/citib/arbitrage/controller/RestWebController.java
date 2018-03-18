package com.citib.arbitrage.controller;
//Receives and processes the HTTP requests from controller.js
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citib.arbitrage.model.*;
import com.citib.arbitrage.service.*;
@RestController
public class RestWebController {
	
	 @Autowired
	 LoginService service;
	 @Autowired
	 CurrentService currservice;
	 @Autowired
	 SavedService savservice;
	
	@RequestMapping(value = "/getalllg", method = RequestMethod.GET)
	public ArrayList<CurrentStock> getResource() throws IOException
	{
		//This function will get the current data from CurrentService and return it to controller.js
		ArrayList<CurrentStock> ar=currservice.Current();
		return ar;
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String postlg(@RequestBody Login lg)
	{
		//This function will check login credentials and send status to controller.js
		 if(service.validateUser(lg))
		 {
			 return "Successful!";
		 }
		 else
		 {
			 return "Failed";
		 }
	}
	
	@RequestMapping(value="/saveData", method=RequestMethod.POST)
	public String saveData(@RequestBody SavedStock ss)
	{
		//This function receives data from UI to be saved in the database
		savservice.tosave(ss);
		return "successful";
	}
	
	@RequestMapping(value = "/getSaved", method = RequestMethod.POST)
	public ArrayList<SavedStock> retrieve(@RequestBody String uid) throws IOException
	{
		//This function will get the saved data and return it to controller.js
		ArrayList<SavedStock> ar=savservice.toretrieve(uid);
		return ar;
	}
}