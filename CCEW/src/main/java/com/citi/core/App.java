/*This class is for performing the CRUD operations on DB*/
package com.citi.core;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.citi.bridge.*;
import com.citi.model.*;
public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CcewApplication.class);
		MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
User u=new User("tanu","tanush",10);  // for checking connectivity basic login data is being*/ 
/*inserted into the DB*/
mongoOperation.save(u);
System.out.println("1. user : " + u);
Query searchUserQuery=new Query(Criteria.where("id").is(1)); //for searching data in DB
User u1 = mongoOperation.findOne(searchUserQuery, User.class);
System.out.println("2. user : " +u1);
	}

}
