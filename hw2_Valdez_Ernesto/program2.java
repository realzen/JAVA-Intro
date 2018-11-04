import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class program2 {

	public static void main(String[] args) throws IOException {
			// to write to the text file
			File file=new File("members.txt");
			FileWriter fw=new FileWriter("members.txt",true);
			PrintWriter pw =new PrintWriter(fw);
			if(file.exists()) //check if the file exits
			{
				System.out.println("************");
			}
		    System.out.println("Hello, welcome!");
		    Scanner in=new Scanner(System.in);
		    Scanner info=new Scanner(System.in);
		    //create the member array maxsize 100
		    String[] members=new String[100];
		    int membercount=0; // counter for the members
		    Menu main=new Menu();
		    member user=new member();
		    //read the txt file into the member array
		    Scanner ifile=new Scanner(System.in);
		    String filename="members.txt";
		    file=new File(filename);
		    Scanner read=new Scanner(file);
		    while(read.hasNextLine())
		    {
		    	members[membercount]=read.nextLine();
		    	membercount++;
		    	
		    }
		
		   System.out.println(members[membercount-1]);
		   String cmp=members[membercount-1];
		   String [] r=cmp.split("//");
		   System.out.println(r[4]);
		   user=new member(r[0],r[4],r[3],r[1],r[2]);
		   
			    			
			    	
			
		    //outer program loop for the first menu
		    while(true)
		    {
		    	int user_input=0;
		    	while(read.hasNextLine())
			    {
			    	members[membercount]=read.nextLine();
			    	membercount++;
			    	
			    }
		    	cmp=members[membercount-1];
		    	r=cmp.split("//");
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
		    	
		    	if(user_input==1)
			    {
		    		while(true)
		    		{
			    		System.out.println("Please Enter your Login information :)");
			    		System.out.print("Username: ");
			    		String user_login=in.next();
			    		System.out.print("Password: ");
			    		String user_pass=in.next();
			    		
			    		boolean user_exists=false;
			    		boolean pass_exists=false;
			    		int tracker=0;
			    		for(int i=0;i<=membercount;i++)
						 {
							  String cmp1=members[i];
							  String[] r1=cmp.split("//");
							  if(r[0].toLowerCase().compareTo(user_login.toLowerCase())==0)
							  {
								  user_exists=true;
								 
								  
							  }
							  tracker++;
						 }
			    		String cmp1=members[tracker-1];
			    		String[] r1=cmp.split("//");
			    		if(r[4].equals(user_pass))
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
			    			System.out.println("Welcome back "+r[1]);
			    			// create the user with the member class
			    			 
			    			 
			    			break;
			    		}
			    		
			    			
		    		
		    		}
		    		
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
				    	}
				    	//2)game
				    	else if(user_input==2)
				    	{
				    		main.display_Game();
				    	}
				    	//3)multimedia
				    	else if(user_input==3)
				    	{
				    		main.display_muiltimedia();
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
					    		//1)display user profile
					    		if(user_input==1)
					    		{
					    			
					    			System.out.println("User's Name: "+user.getFirstname()+" "+ user.getLastname());
					    			System.out.println("User's id: "+user.getID());
					    			System.out.println("User's email: "+user.getEmail());
					    			System.out.println("User's password: "+user.getPassword());
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
					    				user.setPassword(pass);
					    				r[4]=pass;
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
					    				String pass = in.next();
					    				user.setFirstname(pass);
					    				r[1]=pass;
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
					    				String pass = in.next();
					    				user.setLastname(pass);
					    				r[2]=pass;
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
					    				String pass = in.next();
					    				user.setEmail(pass);
					    				r[3]=pass;
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
		    	/////////////////////////////////
			    //2) create account for user   //
		    	/////////////////////////////////
			    else if(user_input==2)
			    {
			    	System.out.print("Enter your First name: ");
			    	String firstname=in.next();
			    	System.out.print("Enter your Last name: ");
			    	String lastname=in.next();
			    	System.out.print("Enter the id you wish to have: ");
			    	String identification=in.next();
			    	String email;
			    	while(true)
			    	{
			    		System.out.print("Enter your email: ");
			    		email=in.next();
			    		for(int i=0;i<membercount;i++)
			    		{ 
			    			String cmp1=members[i];
			    			String[] r1=cmp.split("//");
			    			if(r[3]==email)
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
			    	    // if everything is correct insert the user into the member file
			    	    
			    	    
			    	    	pw.print(identification+"//"+firstname+"//"+lastname+"//"+email+"//"+pass+"//");
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
   