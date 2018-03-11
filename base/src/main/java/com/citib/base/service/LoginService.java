package com.citib.base.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongodb.*;


@Service
public class LoginService {

    public boolean validateUser(String userid, String password)
    {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
		MongoClient client=(MongoClient) context.getBean("mongoClient");
		DB db=client.getDB("mydb");
		DBCollection coll=db.getCollection("Login");
		
		BasicDBObject field = new BasicDBObject();
		field.put("Password", 1);
		DBCursor dbc = coll.find(new BasicDBObject("_id",userid));
		
		if(dbc.hasNext())
		{
			BasicDBObject obj=(BasicDBObject)dbc.next();
			String str=obj.getString("Password");
			return password.equals(str);
		}
		else
		{
			return false;
		}
		
    //    return userid.equalsIgnoreCase("kriti")
   //             && password.equalsIgnoreCase("1234");
    }

}
