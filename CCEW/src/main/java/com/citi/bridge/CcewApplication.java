//Class where connection with DB is being done
package com.citi.bridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mongodb.MongoClient;
@SpringBootApplication
public class CcewApplication {

	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception
	{
		return new SimpleMongoDbFactory(new MongoClient(),"citi");
	}
	public @Bean
	MongoTemplate mongoTemplate() throws Exception{
		MongoTemplate mongoTemplate=new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
	
}

//There is no error in the project, but data is not being inserted into the DB
//Below is one of the line of error it gives post compilation:-
//Exception in thread "main" java.lang.IllegalStateException: Error processing condition on org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration.mongoCustomConversions
//I have not yet checked the errors properly ,but there are quite a few, please look into it, also if anything is wrong with the code.