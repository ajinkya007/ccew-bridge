package com.javasampleapproach.angularjs.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongodb.*;
import com.javasampleapproach.angularjs.model.*;

@Service
public class LoginService {

    public boolean validateUser(Customer cus)
    {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
		MongoClient client=(MongoClient) context.getBean("mongoClient");
		DB db=client.getDB("mydb");
		DBCollection coll=db.getCollection("Login");
		
		BasicDBObject field = new BasicDBObject();
		field.put("Password", 1);
		DBCursor dbc = coll.find(new BasicDBObject("_id",cus.getFirstname()));
		
		if(dbc.hasNext())
		{
			BasicDBObject obj=(BasicDBObject)dbc.next();
			String str=obj.getString("Password");
			return str.equals(cus.getLastname());
			
		}
		else
		{
			return false;
		}
		
    //    return userid.equalsIgnoreCase("kriti")
   //             && password.equalsIgnoreCase("1234");
    }

}