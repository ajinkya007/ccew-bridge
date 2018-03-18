package com.citib.arbitrage.service;
//Used for verifying login
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.citib.arbitrage.model.*;
import com.mongodb.*;

@Service
public class LoginService {

    public boolean validateUser(Login cus)
    {
    	boolean flag = false;
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
		MongoClient client=(MongoClient) context.getBean("mongoClient");
		DB db=client.getDB("mydb");
		DBCollection coll=db.getCollection("Login");
		
		BasicDBObject field = new BasicDBObject();
		field.put("Password", 1);
		DBCursor dbc = coll.find(new BasicDBObject("_id",cus.getusername()));
		
		if(dbc.hasNext())
		{
			BasicDBObject obj=(BasicDBObject)dbc.next();
			String str=obj.getString("Password");
			flag= str.equals(cus.getpassword());	
		}
		else
		{
			flag=false;
		}
		context.close();
		return flag;
    }
    
}