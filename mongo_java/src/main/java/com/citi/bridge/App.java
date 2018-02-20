package com.citi.bridge;
import org.springframework.context.support.*;
import com.mongodb.*;
public class App {
public static void main(String args[])
{
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
MongoClient client=(MongoClient) context.getBean("mongoClient");
DB db=client.getDB("citi");
DBCollection coll=db.getCollection("login");
coll.insert(new BasicDBObject().append("UId","10").append("Username","geet").append("Password","123"));
coll.insert(new BasicDBObject().append("UId","11").append("Username","bkm").append("Password", "9869"));

//above is sample data that is being inserted in login table.
}
}
