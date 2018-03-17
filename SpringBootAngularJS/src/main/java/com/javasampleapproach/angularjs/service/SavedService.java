package com.javasampleapproach.angularjs.service;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.javasampleapproach.angularjs.model.SavedStock;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
import com.mongodb.*;
//import com.mongodb.DBCollection;
//import com.mongodb.MongoClient;

@Service
public class SavedService {
//	SavedStock s=new SavedStock();
	
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
	MongoClient client=(MongoClient) context.getBean("mongoClient");
	DB db=client.getDB("mydb");
	DBCollection coll=db.getCollection("Saved");
	
	//BasicDBObject field = new BasicDBObject();
	
	public void tosave(SavedStock s)
	{
		
			/*Stockname=s.stockName;
			id=s.userId;
			System.out.println(Stockname+" "+id);*/
				//System.out.println()+" "+s.getDate()+" "+s.getTime()+" "+s.getUserId()+" "+s.getBsePrice()+" "+s.getNsePrice()+" "+s.getProfit());
			BasicDBObject field = new BasicDBObject();
			field.append("userId",s.userId).append("stockName", s.stockName).append("nsePrice",s.nsePrice).append("bsePrice",s.bsePrice).append("profit",s.profit).append("date", s.date).append("time",s.time);
			coll.insert(field);
		
		
	}
	public void display(SavedStock s)
	{
		System.out.println("Save Service");
		s.display();
		
	}
	/*function to retrieve data*/
	
	public ArrayList<SavedStock> toretrieve(String usr)
	{
		//DBCursor cursor=coll.find();
		DBCursor cursor1=coll.find();
		ArrayList<SavedStock> ss=new ArrayList<SavedStock>();
		SavedStock s;
		System.out.println(usr);
		//System.out.println(sav.userId);
		BasicDBObject searchquery=new BasicDBObject("userId",usr);
		cursor1=coll.find(searchquery);
		while(cursor1.hasNext())
		{
			s=new SavedStock();
			BasicDBObject obj=(BasicDBObject)cursor1.next();
			s.setStockName(obj.getString("stockName"));
			s.setBsePrice(obj.getDouble("bsePrice"));
			s.setNsePrice(obj.getDouble("nsePrice"));
			s.setDate(obj.getString("date"));
			s.setTime(obj.getString("time"));
			s.setProfit(obj.getDouble("profit"));
			s.setUserId(obj.getString("userId"));
			s.display();
			ss.add(s);
			
			//System.out.println(cursor1.next());
		}
		cursor1.close();
		

		return ss;
		
	}

}
