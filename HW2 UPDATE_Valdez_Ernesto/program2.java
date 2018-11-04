/*
 * NAME: ERNESTO VALDEZ
 * DATE:
 * DESCRIPTION: THIS PROGRAM CREATES A LOGIN MENU WHERE THE USER IS ABLE TO SIGNUP THEN LOGIN
 *  AND ABLE TO LOOK AT THEIR INFORMATION AND MODIFY THEIR INFORMATION ASWELL
 *  
 *  UPDATE 1: MODIFIED THE PROGRAM SO THAT ONCE THE USER TRIES TO LOGIN AFTER 5 TIMES IT LETS THEM BACK INTO THE
 *   THE MAIN MENU, BEFORE THE UPDATE THE USER WOULD BE STUCK IN THAT MENU FORA LONG TIME AND WAS UNABLE TO GET OUT
 *   
 *   UPDATE 2: ENVELOPED THE MEMBER MENU WHILE LOOP IN ANOTHER WHILE LOOP THAT CHECKS WHETHER THE USER PASSWORD IS
 *   CORRECT AS WELL AS THE USER NAME IF NOT ONE CANNOT ENTER INTO THE MEMBER MENU, BEFORE IT BEFORMED A SIMILAR CHECK 
 *   BUT IN A SPECIAL CASE YOU COULD BE ABLE TO BYPASS IT AND GET INTO THE MEMBER MENU WITHOUT HAVING AN ACCOUNT
 *   
 *   UPDATE 3: THE MEMBER ARRAY WAS THAT WAS PREVIOUSLY NOT WORKING SHOULD BE WORKING NOW BECAUSE I HAVE CREATED AN
 *   ARRAY OF TYPE MEMEBER, BEFORE I WAS JUST STORING ALL THE INFORMATION IN THE MEMBER FILE.
 *   
 *   UPDATE 4 : CREATING A NEW MEMBER WAS WORKING BUT NOT AS INTEDED AND WITH THE NEW CHAGES I DID IN MY IMPLEMENTATION
 *   I HAD TO CHANGE THE WAY NEW MEMBERS WERE BEING ADDED USING THE NEW MEMBER TYPE ARRAY 
 */
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class program2 {

	public static void main(String[] args) throws IOException {
			
			
			
			 member [] member_data=new member[100];
		    member new_member=new member();
			 Scanner in=new Scanner(System.in);
		    Scanner info=new Scanner(System.in);
		    //create the member array maxsize 100
		    //String[] members=new String[100];
		    int membercount=0; // counter for the members
		    Menu main=new Menu();
		    //member user=new member();
		    //read the txt file into the member array
		    Scanner ifile=new Scanner(System.in);
		    //String filename="members.txt";
		    //file=new File(filename);
		    
		    
		  
		   
		    
		   
			    			
		   boolean user_exists=false;
		    boolean pass_exists=false;
			
		    //outer program loop for the first menu
		    while(true)
		    {
		    	
		    	  // to write to the text file
				File file=new File("members.txt");
				FileWriter fw=new FileWriter("members.txt",true);
				PrintWriter pw =new PrintWriter(fw);
				Scanner read=new Scanner(file);
			    
				if(file.exists()) //check if the file exits
				{
					System.out.println("************");
				}
			    System.out.println("Hello, welcome!");
			   
			   
			    
			   //UPDATE 3:
			    /**************************************************************************************
			     * This is the new implementation that I made in order to properly store and read the 
			     * member data. 
			     **************************************************************************************/
			    
			  
			    //read the member data that is in the member txt file
			    for (int m=0;read.hasNext();m++) // read through the file while there is something there and put into the array
			    {
			    	member_data[m]=new member(); // member type array of ize 100
			    	String cmp=read.nextLine();
			    	String [] r=cmp.split("//");
			    	member_data[m].id=r[0]; // gets the first column  and so on for the other ones 
			    	member_data[m].fname=r[1]; //first name = column 2
			    	member_data[m].lname=r[2]; // last name =  column 3
			    	member_data[m].email=r[3]; //  email = column 4
			    	member_data[m].password=r[4]; // password=column 5
			    	membercount++; // to keep the size of the members
			    	
			    }
			    
			    System.out.println("~~~~~~~~~~~~~These are all the members~~~~~~");
			    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			    for (int m=0;m<membercount;m++) // read through the file while there is something there and put into the array
			    {
			    	
			    	System.out.println("id:"+member_data[m].id);
			    	System.out.println("first name:"+member_data[m].fname);
			    	System.out.println("last name:"+member_data[m].lname);
			    	System.out.println("email:"+member_data[m].email);
			    	System.out.println("password:"+member_data[m].password);
			    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
			    	System.out.println("");
			    	
			    }
		    	
		    	
		    	
		    	
		    	int user_input=0;
		    	main.display_loginMenu();
		    	user_input=in.nextInt();
		    	while(user_input>3 || user_input<1)
		    	{
		    		System.out.println("error please try again:> ");
		    		main.display_loginMenu();
		    		user_input=in.nextInt();
		    	}
		    	
		    	///////////////////////////////////////////
			    //        1) the users login menu        //
		    	///////////////////////////////////////////	
		    	
		    	int tracker=0; // keep track of user we find
				if(user_input==1)
			    {
		    		int num_times=5; // the nuber of tries you have to tru and log in if not you will be reverted back
		    		while(num_times>0)
		    		{
			    		System.out.println("Please Enter your Login information :)");
			    		System.out.print("Username: ");
			    		String user_login=in.next();
			    		System.out.print("Password: ");
			    		String user_pass=in.next();
			    		
			    		
			    		
			    		for(int i=0;i<membercount;i++)
						 {
							  //String cmp1=members[i];
							  //String[] r1=cmp1.split("//");
			    			  //member_data[i].id=member_data[i].id.toLowerCase();
			    			  //user_login=user_login.toLowerCase();
			    			  //System.out.println(member_data[i].id);
			    				
							  if(member_data[i].id.compareTo(user_login)==0)
							  {
								  //System.out.println(member_data[i].id);
								  user_exists=true;
								  tracker=i;
								  break;
								  
							  }
							  
							  
						 }
			    		if(member_data[tracker].password.equals(user_pass))
			    		{
			    			pass_exists=true;
			    		}
			    		
	
			    		if(user_exists==false)
			    		{
			    			System.out.println("User "+"'"+user_login+"'"+ " does not exist please try again:");
			    		}
			    		else if(user_exists==true && pass_exists==false)
			    		{
			    			System.out.println("You entered the incorrect password");
			    		
			    		}
			    		else if(user_exists==true &&pass_exists==true)
			    		{
			    			//System.out.println("Welcome back "+r[1]);
			    			// create the user with the member class
			    			 
			    			 
			    			break;
			    		}
			    		num_times--;
			    		if(num_times ==0)
			    		{
			    			System.out.println("");
			    			System.out.println("");
			    			System.out.println("");
			    			System.out.println("Have exceed the number of login attempts please try again");
			    			System.out.println("");
			    			System.out.println("");
			    			System.out.println("IF YOU DO NOT HAVE AN ACCOUNT PLEASE CREATE ONE USING THE SINGUP OPTION");
			    			System.out.println("");
			    			System.out.println("");
			    			
			    		}
			    			
		    		
		    		}
		    		if(user_exists==true && pass_exists==true)
		    		{
		    			new_member=member_data[tracker];
		    			System.out.println("Welcome back "+member_data[tracker].fname+" "+member_data[tracker].lname);
				    	while(true)
				    	{
				    		
				    		//display new menu and get user input
				    		main.display_userMenu();
				    		user_input=in.nextInt();
				    		//check if user input is correct
				    		while(user_input>5||user_input<1)
				    		{
				    			System.out.println("Error..THATS THE WRONG NUMBER!");
				    			main.display_userMenu();
				    			user_input=in.nextInt();
				    		}
					    	//1)utility
					    	if(user_input==1)
					    	{
					    		main.display_utilityMenu();
					    		System.out.println("press enter to return to menu");
					    		System.in.read();
					    	}
					    	//2)game
					    	else if(user_input==2)
					    	{
					    		main.display_Game();
					    		System.out.println("press enter to return to menu");
					    		System.in.read();
					    	}
					    	//3)multimedia
					    	else if(user_input==3)
					    	{
					    		main.display_muiltimedia();
					    		System.out.println("press enter to return to menu");
					    		System.in.read();
					    	}
					    	//4)update profile***************
					    	else if(user_input==4)
					    	{
					    		//display new menu
					    		///////////////////////////////////
					    		///        Profile               //
					    		///////////////////////////////////
					    		while(true)
					    		{
						    		main.display_profile();
						    		user_input=in.nextInt();
						    		
						    		//make sure the input is correct
						    		while(user_input>6||user_input<1)
						    		{
						    			System.out.println("ERROR...THATS THE WRONG NUMBER!!");
						    			main.display_profile();
						    			user_input=in.nextInt();
						    		}
						    		member_data[tracker]=new_member;
						    		//1)display user profile
						    		if(user_input==1)
						    		{
						    			
						    			System.out.println("User's Name: "+new_member.fname+" "+new_member.lname);
						    			System.out.println("User's id: "+new_member.id);
						    			System.out.println("User's email: "+new_member.email);
						    			System.out.println("User's password: "+new_member.password);
						    			System.out.println("*********Press enter to go back to the previous menu******");
						    			System.in.read();
						    		}
						    		//2)change user password
						    		else if(user_input==2)
						    		{
						    			System.out.println("Are you sure you want to change your password?");
						    			System.out.println("Please enter (1)|Yes| or (2)|NO| |[*Numbers Only!*]|");
						    			int user_choice=in.nextInt();
						    			while(user_choice<1||user_choice>2)
						    			{
						    				System.out.println("WRONG NUMBER");
						    				System.out.println("Are you sure you want to change your password?");
							    			System.out.println("Please enter (1)Yes or (2)NO [*Numbers Only!*]");
							    			user_choice=in.nextInt();
						    				
						    			}
						    			if(user_choice==1)
						    			{
						    				System.out.println("Enter your new password :");
						    				String pass = in.next();
						    				new_member.password=pass;
						    				   FileWriter  new_fw= new FileWriter("members.txt",false);
								    			PrintWriter new_print=new PrintWriter(fw);
										    	for(int i=0;i<membercount;i++)
							    				{
							    					
							    					new_print.println(member_data[i].id+
							    					"//"+member_data[i].fname+
							    					"//"+member_data[i].lname+
							    					"//"+member_data[i].email+
							    					"//"+member_data[i].password+"//");
							    					
							    				}
										    	
										    	new_print.close();
						    				
						    				
						    				
						    				
						    			}
						    			else if(user_choice==2)
						    			{
						    				break;
						    			}
						    			
						    		}
						    		//3)change user first name
						    		else if(user_input==3)
						    		{
						    			System.out.println("Are you sure you want to change your first name?");
						    			System.out.println("Please enter (1)Yes or (2)NO [*Numbers Only!*]");
						    			int user_choice=in.nextInt();
						    			while(user_choice<1||user_choice>2)
						    			{
						    				System.out.println("WRONG NUMBER");
						    				System.out.println("Are you sure you want to change your first name?");
							    			System.out.println("Please enter (1)Yes or (2)NO [*Numbers Only!*]");
							    			user_choice=in.nextInt();
						    				
						    			}
						    			if(user_choice==1)
						    			{
						    				System.out.print("Enter your new first name: ");
						    				String new_first = in.next();
						    				new_member.fname=new_first;
						    				   FileWriter  new_fw= new FileWriter("members.txt",false);
								    			PrintWriter new_print=new PrintWriter(fw);
										    	for(int i=0;i<membercount;i++)
							    				{
							    					
							    					new_print.println(member_data[i].id+
							    					"//"+member_data[i].fname+
							    					"//"+member_data[i].lname+
							    					"//"+member_data[i].email+
							    					"//"+member_data[i].password+"//");
							    					
							    				}
										    	
										    	new_print.close();
						    				
						    		
							    				
						    			}
						    			else if(user_choice==2)
						    			{
						    				break;
						    			}
						    		}
						    		//4)change user last name
						    		else if(user_input==4)
						    		{
						    			System.out.println("Are you sure you want to change your last name?");
						    			System.out.println("Please enter (1)Yes or (2)NO [*Numbers Only!*]");
						    			int user_choice=in.nextInt();
						    			while(user_choice<1||user_choice>2)
						    			{
						    				System.out.println("WRONG NUMBER");
						    				System.out.println("Are you sure you want to change your last name?");
							    			System.out.println("Please enter (1)Yes or (2)NO [*Numbers Only!*]");
							    			user_choice=in.nextInt();
							    			
						    				
						    			}
						    			if(user_choice==1)
						    			{
						    				System.out.println("Enter your new last name:");
						    				String new_last = in.next();
						    				new_member.lname=new_last;
						    				   FileWriter  new_fw= new FileWriter("members.txt",false);
								    			PrintWriter new_print=new PrintWriter(fw);
										    	for(int i=0;i<membercount;i++)
							    				{
							    					
							    					new_print.println(member_data[i].id+
							    					"//"+member_data[i].fname+
							    					"//"+member_data[i].lname+
							    					"//"+member_data[i].email+
							    					"//"+member_data[i].password+"//");
							    					
							    				}
										    	
										    	new_print.close();
						    			}
						    			else if(user_choice==2)
						    			{
						    				break;
						    			}
						    			
						    		}
						    		//5)change email
						    		else if(user_input==5)
						    		{
						    			System.out.println("Are you sure you want to change your email?");
						    			System.out.println("Please enter (1)Yes or (2)NO [*Numbers Only!*]");
						    			int user_choice=in.nextInt();
						    			while(user_choice<1||user_choice>2)
						    			{
						    				System.out.println("WRONG NUMBER");
						    				System.out.println("Are you sure you want to change your email?");
							    			System.out.println("Please enter (1)Yes or (2)NO [*Numbers Only!*]");
							    			user_choice=in.nextInt();
						    				
						    			}
						    			if(user_choice==1)
						    			{
						    				System.out.println("Enter your new email:");
						    				String new_email = in.next();
						    				new_member.email=new_email;
						    				   FileWriter  new_fw= new FileWriter("members.txt",false);
								    			PrintWriter new_print=new PrintWriter(fw);
										    	for(int i=0;i<membercount;i++)
							    				{
							    					
							    					new_print.println(member_data[i].id+
							    					"//"+member_data[i].fname+
							    					"//"+member_data[i].lname+
							    					"//"+member_data[i].email+
							    					"//"+member_data[i].password+"//");
							    					
							    				}
										    	
										    	new_print.close();
						    				
						    			}
						    			else if(user_choice==2)
						    			{
						    				break;
						    			}
						    			
						    		}
						    		//6)exit
						    		else if(user_input==6)
						    		{
						    			break;
						    		}
						    		
						 
					    		}
					    		
					    	}
					    	
					    	// go back********************
					    	else if(user_input==5)
					    	{
					    		break;
					    	}
				    	}
				    }
			    }
		    	/////////////////////////////////
			    //2) create account for user   //
		    	/////////////////////////////////
			    else if(user_input==2)
			    {
			    	
			    	////////////////////////////////////////////////////////////////////////////////////////
			    	// UPDATE 4: I CHANGED THE WAY I WAS ADDING THE CREATED USER IN THE WHOLE CODE SEGMENT//
			    	////////////////////////////////////////////////////////////////////////////////////////
			    	System.out.print("Enter your First name: ");
			    	new_member.fname=in.next();
			    	System.out.print("Enter your Last name: ");
			    	new_member.lname=in.next();
			    	System.out.print("Enter the id you wish to have: ");
			    	new_member.id=in.next();
			    	String email;
			    	while(true)
			    	{
			    		System.out.print("Enter your email: ");
			    		new_member.email=in.next();
			    		for(int i=0;i<membercount;i++)
			    		{ 
			    			{
			    				
			    				
			    			}
			    			
			    		}
			    		break;
			    	}
			    	String pass=null;
			    	//check if the password is secure
			    		boolean upper=true;
			    		boolean lower=true;
			    		boolean number=false;
			    		boolean special =false;
			    	while(true)
			    	{	
			    		
			    		System.out.println("Enter the password for your acount");
			    		System.out.println("*please include upper and lowercase lettter a number and a special character*");
			    		System.out.print(": ");
			    		pass=in.next();
			    		
				    		//check for numbers		
				    		if(!pass.matches(".*\\d+.*"))
				    		{
				    			System.out.println("Missing number");
				    		}
				    		//check for uppercase
			    		
				    		if(pass.matches(".* [A-Z] *."))
				    		{
				    			System.out.println("Missing uppercase letter");
				    			
				    		}
				    		// check for lowercases
				    		if(pass.matches(".* [a-z] *."))
				    		{
				    			System.out.println("Missing lowercase");
				    			
				    		}
			    		
			    		//check for special characters
			    		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
			    	    Matcher matcher = pattern.matcher(pass);
			    	    if(matcher.matches())
			    	    {
			    	    	
			    	    	System.out.println("Missing special character");
			    	    	
			    	    }
			    	    if(!matcher.matches()&&pass.matches(".*\\d+.*"))
			    	    {
			    	    	break;
			    	    }
			    	    
			    	   
			    	
			    	}
			    	new_member.password=pass;
			    	    // if everything is correct insert the user into the member file
			    	    
			    	    
			    	    	pw.print(new_member.id+"//"+
			    	    	new_member.fname+
			    	    	"//"+new_member.lname+
			    	    	"//"+new_member.email+
			    	    	"//"+new_member.password+"//");
			    	    	pw.println();
			    	    	pw.close();
			    	//user=new member(identification,pass,email,firstname,lastname); 
			    	// create the new user
			    	
			    }
			    //exit the menu
			    else if(user_input==3)
			    {
			    	System.out.println("Good Bye! \\^_^//");
			    	System.out.println("**************************************");
			    	break;
			    	
			    }
		    	
		    }
	}

}
   