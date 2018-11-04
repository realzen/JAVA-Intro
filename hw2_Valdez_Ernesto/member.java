import java.util.*;
import java.io.*;
public class member {
	String id;
	String password;
	String email;
	String fname;
	String lname;
	//deafault constructor
	member() 
	{
		//does nothing
	}
	//parameterized constructor to set all variables
	member(String iden, String pass, String emai, String first, String last) 
	{
		id=iden;
		password=pass;
		email=emai;
		fname=first;
		lname=last;
		
	}
	//gets the user id
	String getID() 
	{
		return id;
	}
	// gets the user password
	String getPassword() 
	{
		return password;
	}
	// gets the users first name
	String getFirstname() 
	{
		return fname;
	}
	//gets the users last name
	String getLastname() 
	{
		return lname;
	}
	// gets the users email
	String getEmail() 
	{
		return email;
	}
	//sets the users id 
	void setID(String str) 
	{
		id=str;
	
	}
	//sets the users password
	void setPassword(String str)
	{
		password=str;
	}
	void setFirstname(String str) 
	{
		fname=str;
	}
	void setLastname(String str) 
	{
		lname=str;
	}
	void setEmail(String str) 
	{
		email=str;
	}

}
