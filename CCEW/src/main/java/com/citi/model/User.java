/*This class is for accepting inputs to the DB*/
package com.citi.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="login")
public class User {

	int id;
String username;
String password;

User()

    { 
		password="";
        username= "";
        id=0;
    }

     
public User(String un,String pwd, int i)
{
 username=un;
 password=pwd;
 id=i;
}

     

    public String getName()

    {
        return username;
    }

    public void setName(String a)

    {
        username=a;
    }

     public int getid()

    {
    	return id;
    }

    public void setid(int pn){

        id=pn;
    }

    public String getpwd()

    {
    	return password;
    }

    public void setpwd(String p)
    {

        password=p;
    }

    void print()

    {
 System.out.println("UserID: " + id + " UserName: " + username + "Password" + password);
    }


}
