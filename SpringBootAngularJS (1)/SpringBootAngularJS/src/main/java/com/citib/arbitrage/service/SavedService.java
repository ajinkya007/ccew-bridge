package com.citib.arbitrage.service;
//Provide service to access saved stock from database 
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.citib.arbitrage.model.SavedStock;
import com.mongodb.*;

@Service
public class SavedService
{
	
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
	MongoClient client=(MongoClient) context.getBean("mongoClient");
	DB db=client.getDB("mydb");
	DBCollection coll=db.getCollection("Saved");
		
	public void tosave(SavedStock s)
	{
		BasicDBObject field = new BasicDBObject();
		field.append("userId",s.userId).append("stockName", s.stockName).append("nsePrice",s.nsePrice).append("bsePrice",s.bsePrice).append("profit",s.profit).append("date", s.date).append("time",s.time);
		coll.insert(field);
		
	}
	/*function to retrieve data*/
	public ArrayList<SavedStock> toretrieve(String usr)
	{
		DBCursor cursor1=coll.find();
		ArrayList<SavedStock> ss=new ArrayList<SavedStock>();
		SavedStock s;
		BasicDBObject searchquery=new BasicDBObject("userId",usr);
		cursor1=coll.find(searchquery).sort(new BasicDBObject("date",-1)).sort(new BasicDBObject("time",-1));
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
			ss.add(s);			
		}
		cursor1.close();
		return ss;
	}

}
