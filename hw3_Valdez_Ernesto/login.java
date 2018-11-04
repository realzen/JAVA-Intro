/*
 * NAME:Ernesto Valdez
 * DATE: 11-8-16
 * DESCRIPTION: THIS CLASS WORKS WITH THE MAIN CLASS AND HAS ALL THE METHODS TO MAKE THE MENUS AND 
 * OUTPUT THE CORRECT INFORMATION
 * */
import java.util.*;
import java.io.IOException;
import java.sql.*;
public class login
{
	Scanner scan=new Scanner(System.in);
	
	void display_main_menu()
	{
		
		System.out.println("------LOGIN MENU--------" );
		System.out.println("Please Enter your option with a number");
		System.out.println("(1)Login");
		System.out.println("(2)Sign up");
		System.out.println("(3)Exit");
		System.out.println("Please imput your choice");
		
	
		
		
	}
	void display_userMenu() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		int user_option; // to store the user option
		while(true)
		{
			System.out.println("------USER MENU-------");
			System.out.println("(1)Display Invetory");
			System.out.println("(2)Sort cars");
			System.out.println("(3)Log out"); 
			System.out.println("Please Imput your choice");
			user_option = scan.nextInt(); // takes the input of the user
			while(user_option<1 || user_option >3)
			{
				System.out.println("Please enter a correct option");
				System.out.print(">");
				user_option=scan.nextInt();
				
			}
			if (user_option == 1) 
			{
				System.out.println("option 1");
				display_inventoryMenu();
			} 
			else if (user_option == 2)
			{
				
				sort_cars();
			}
			else if (user_option == 3) {
				System.out.println("Loging out .......................");
				break;
			}
		}
		
	}
	void display_inventoryMenu() throws InstantiationException, IllegalAccessException,ClassNotFoundException, SQLException
	{
	  //display all the cars database
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
		Statement statement =connection.createStatement();
		ResultSet rs= statement.executeQuery("select * from Cars");
		while(rs.next())
		{
				// implement here
			
			System.out.print(rs.getString("Vin")+" ");
			System.out.print(rs.getString("brand")+" ");
			System.out.print(rs.getString("model")+" ");
			System.out.print(rs.getString("year")+" ");
			System.out.print(rs.getInt("mileage")+" ");
			System.out.print(rs.getString("color")+" ");
			
			System.out.println(" ");
			
		}
		connection.close();
		
		
	}
	//sorts the cars in the order the user wants
	void sort_cars() throws InstantiationException, IllegalAccessException,ClassNotFoundException, SQLException
	{
		int user_choice;
		Scanner user=new Scanner(System.in);
		System.out.println("1)Sort by VIN");
		System.out.println("2)Sort by Brand");
		System.out.println("3)Sort by Model");
		System.out.println("4)Sort by year");
		System.out.println("5)Sort by Mileage");
		System.out.println("6)Sort by Price");
		System.out.println("7)Sort by color");
		user_choice=user.nextInt();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
		Statement st = conn.createStatement();
		String whatever;
		
		while(user_choice<1 || user_choice>7)
		{
			System.out.println("Please enter correct number");
			System.out.print(">");
			user_choice=user.nextInt();
		}
		if(user_choice==1)
		{
			String sqlstr = "select * from cars ORDER BY vin DESC;";
			ResultSet rs = st.executeQuery(sqlstr);
			while(rs.next())
			{
					// implement here
				
				System.out.print(rs.getString("Vin")+" ");
				System.out.print(rs.getString("brand")+" ");
				System.out.print(rs.getString("model")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getInt("mileage")+" ");
				System.out.print(rs.getString("color")+" ");
				
				System.out.println(" ");
				
			}
			
			
		}
		else if(user_choice==2)
		{
			String sqlstr = "select * from cars ORDER BY brand DESC;";
			ResultSet rs = st.executeQuery(sqlstr);
			while(rs.next())
			{
					// implement here
				
				System.out.print(rs.getString("Vin")+" ");
				System.out.print(rs.getString("brand")+" ");
				System.out.print(rs.getString("model")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getInt("mileage")+" ");
				System.out.print(rs.getString("color")+" ");
				
				System.out.println(" ");
				
			}
			
		}
		else if(user_choice==3)
		{
			String sqlstr = "select * from cars ORDER BY model DESC;";
			ResultSet rs = st.executeQuery(sqlstr);
			while(rs.next())
			{
					// implement here
				
				System.out.print(rs.getString("Vin")+" ");
				System.out.print(rs.getString("brand")+" ");
				System.out.print(rs.getString("model")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getInt("mileage")+" ");
				System.out.print(rs.getString("color")+" ");
				
				System.out.println(" ");
				
			}
		}
		else if(user_choice==4)
		{
			String sqlstr = "select * from cars ORDER BY year DESC;";
			ResultSet rs = st.executeQuery(sqlstr);
			while(rs.next())
			{
					// implement here
				
				System.out.print(rs.getString("Vin")+" ");
				System.out.print(rs.getString("brand")+" ");
				System.out.print(rs.getString("model")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getInt("mileage")+" ");
				System.out.print(rs.getString("color")+" ");
				
				System.out.println(" ");
				
			}
		}
		else if(user_choice==5)
		{
			String sqlstr = "select * from cars ORDER BY mileage DESC;";
			ResultSet rs = st.executeQuery(sqlstr);
			while(rs.next())
			{
					// implement here
				
				System.out.print(rs.getString("Vin")+" ");
				System.out.print(rs.getString("brand")+" ");
				System.out.print(rs.getString("model")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getInt("mileage")+" ");
				System.out.print(rs.getString("color")+" ");
				
				System.out.println(" ");
				
			}
		}
		else if(user_choice==6)
		{
			String sqlstr = "select * from cars ORDER BY price DESC;";
			ResultSet rs = st.executeQuery(sqlstr);
			while(rs.next())
			{
					// implement here
				
				System.out.print(rs.getString("Vin")+" ");
				System.out.print(rs.getString("brand")+" ");
				System.out.print(rs.getString("model")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getInt("mileage")+" ");
				System.out.print(rs.getString("color")+" ");
				
				System.out.println(" ");
				
			}
		}
		else if(user_choice==7)
		{
			String sqlstr = "select * from cars ORDER BY color DESC;";
			ResultSet rs = st.executeQuery(sqlstr);
			while(rs.next())
			{
					// implement here
				
				System.out.print(rs.getString("Vin")+" ");
				System.out.print(rs.getString("brand")+" ");
				System.out.print(rs.getString("model")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getInt("mileage")+" ");
				System.out.print(rs.getString("color")+" ");
				
				System.out.println(" ");
				
			}
			
		}
	}
	// this function adds a user to the database and also checks if the user is in the dabase already 
	// and if they are then its tells them that they are and tells them to login
	void create_account() throws InstantiationException, IllegalAccessException,ClassNotFoundException, SQLException
	{
		
		//create variables to store the information
		Scanner user=new Scanner(System.in);
		String id;
		String password;
		String second_password;
		String first_name;
		String last_name;
		String email;
		System.out.println("-----SIGN UP MENU------");
		System.out.print("Please input your id: ");
		//should probably check if the user id already exists
		// ge the user input then go through the data base to check if the user already exists
		// DO LATER	
		id=user.nextLine();
		System.out.print("Please input your password(ONLY NUMBERS): ");
		password=user.next();
		System.out.print("Please input your password again(ONLY NUMBERS): ");
		second_password=user.next();
		if(!second_password.equals(password))
		{
			while(!second_password.equals(password))
			{
				System.out.println("Please input your password again...they do not match(PLEASE ONLY USE NUMBERS");
				System.out.print(">");
				password=user.next();
				System.out.println("Enter your password again");
				second_password=user.next();
				
			}
		}
		System.out.print("Please input your first name: ");
		first_name=user.next();
		System.out.print("Please input your last name: ");
		last_name=user.next();
		System.out.print("Please input your email: ");
		email=user.next();
		System.out.println("Thank you" +" "+first_name+" "+"for signing up!");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","ernesto");
		Statement st = conn.createStatement();
		String sqlstr = "INSERT INTO members VALUES ("+"'"+id+"'"+","+ "'"+password+"'" +","+ "'"+first_name +"'"+","+"'"+last_name +"'"+","+ "'"+email+"'"+");";
		st.executeUpdate(sqlstr);
	
	
	}
	void check_database() throws InstantiationException, IllegalAccessException,ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
		Statement statement =connection.createStatement();
		ResultSet rs= statement.executeQuery("select * from members");
		while(rs.next())
		{
				// implement here
			
			System.out.print(rs.getString("id")+" ");
			System.out.print(rs.getString("password")+" ");
			System.out.print(rs.getString("firstname")+" ");
			System.out.print(rs.getString("lastname")+" ");
			System.out.print(rs.getString("email")+" ");
			
			System.out.println(" ");
			
		}
		connection.close();
		
	}
	//this fucntion should check if the user has an account and return false if there isnt one
	int login() throws InstantiationException, IllegalAccessException,ClassNotFoundException, SQLException, IOException
	{
		//variables to store the user information
		Scanner user_info=new Scanner(System.in); // to scan the user input
		String user_id;
		String user_password;
		// variabkles to compare the user to member information
		String member_id;
		String member_password;
		String member_firstname;
		String member_lastname;
		String member_email;
		System.out.println("------------LOGIN MENU-------------");
		System.out.print("Please input your user id: ");
		user_id=user_info.next();
		System.out.print("Please enter your password: ");
		user_password=user_info.next();
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
		Statement statement =connection.createStatement();
		ResultSet rs= statement.executeQuery("select * from members Where id="+"'"+user_id+"'");
		//while(rs.next())
		//{
		//check if the admin as signed in if it has display a different menu
		//return 3 for admin return 1 for regular user and return 0 for not a user
		
			if(user_id.equals("admin") &&user_password.equals("adminpass"))
			{
				
				return 3;
			}
			else if(rs.next())
			{
			// get all the user data
				member_id = rs.getString(1);
				member_password = rs.getString(2);
				member_firstname = rs.getString(3);
				member_lastname = rs.getString(4);
				member_email = rs.getString(5);
				if(member_password==user_password)
				{
					System.out.println("Success!!!!");
					System.out.println("Welcomeback "+member_firstname+" "+member_lastname);
					return 1;
				}
				else
				{
					System.out.println("wrong password!");
					
					
					return 0;
				}
				
				
				
			}
			else
			{
				System.out.println("You dont seem to be a user , please register in the main menu");
				System.out.println("Press enter to continue back to the main page......");
				System.in.read();
				//display_main_menu();
				return 0;
			}
			
		//}

		
	
		
	}
	
	void admin_account() throws InstantiationException, IllegalAccessException,ClassNotFoundException, SQLException, IOException
	{
		Scanner user_choice=new Scanner(System.in);
		int user;
		while(true)
		{
			System.out.println("Welcome back Super User");
			System.out.println("----ADMIN MENU----");
			System.out.println("1)Display Inverntory");
			System.out.println("2)Add Car");
			System.out.println("3)Delete Car");
			System.out.println("4)Update Car");
			System.out.println("5)Display Users");
			System.out.println("6)Add User");
			System.out.println("7)Dlete User");
			System.out.println("8)Update User");
			System.out.println("9)Logout");
			System.out.println("Please enter the number of your choice");
			user=user_choice.nextInt();
			
			while(user<1 || user>9)
			{
				System.out.println("Please enter a correct answer!");
				System.out.println("Enter your choice again");
				System.out.print(">");
				user=user_choice.nextInt();
				
			}
			if(user==1)
			{
				display_inventoryMenu(); // just call the function to display the menu
				
			}
			else if(user==2)
			{
				Scanner car=new Scanner(System.in);
				//variables to store the user information
				String VIN;
				String Brand;
				String Model;
				int Year;
				int Mileage;
				int Price;
				String Color;
				System.out.print("Please input the VIN number: ");
				VIN=car.next();
				System.out.print("Please input the car Brand: ");
				Brand=car.next();
				System.out.print("Please input the car Model: ");
				Model=car.next();
				System.out.print("Please input the car's Year: ");
				Year=car.nextInt();
				System.out.print("Please intput the cars Mileage: ");
				Mileage=car.nextInt();
				System.out.print("Please enter the cars Price: ");
				Price=car.nextInt();
				System.out.print("Please enter the cars Color: ");
				Color=car.next();
				System.out.println("Thank you the following information will be stored: "+VIN+"-"+Brand+"-"+Model+"-"+Year+"-"+Mileage+"-"+Price+"-"+Color);
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","ernesto");
				Statement st = conn.createStatement();
				String sqlstr = "INSERT INTO cars VALUES ("+"'"+VIN+"'"+","+ "'"+Brand+"'" +","+ "'"+Model +"'"+","+Year+","+ Mileage+","+Price+","+"'"+Color+"'"+");";
				st.executeUpdate(sqlstr);
				System.out.println("-------------------------------------------------------");
				System.out.println("THIS IS THE NEW INVENTORY");
				display_inventoryMenu();
				System.out.println("Press enter to continue to the main menu");
				System.in.read();
				
			}
			else if(user==3)
			{
				display_inventoryMenu ();
				System.out.println("--------------------------------------------");
				// lets delete the car that of your choosing
				Scanner delete= new Scanner(System.in);
				String Vin;
				System.out.print("Please input eh VIN number of the vehincle you wish delete: ");
				Vin=delete.next();
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","ernesto");
				Statement st = conn.createStatement();
				String sqlstr = "DELETE FROM cars WHERE VIN ="+"'"+ Vin+"'"+";";
				st.executeUpdate(sqlstr);
				System.out.println("Car deleted!......(DOUBLE CHECK THE INVETORY TO BE SURE)");
				System.out.println("Press enter to go back to the menu");
				System.in.read();
				
				
			}
			else if(user==4)
			{
				while(true)
				{
				// lets update the car 
					System.out.println("------------------------------------------");
					display_inventoryMenu();
					System.out.println("------------------------------------------");
					Scanner add = new Scanner(System.in);
					int user_choice1;
					String Vin;
					String update = null;
					String update_choice = null;
					int update_choiceInt = 0;
					System.out.print("Please input the VIN number of the car you wish update: ");
					Vin=add.next();
					System.out.println("-------------------------------------------");
					System.out.println("1)Update brand");
					System.out.println("2)Update model");
					System.out.println("3)Update year");
					System.out.println("4)Update mileage");
					System.out.println("5)Update price");
					System.out.println("6)Update color");
					System.out.print("Please enter the number of the option you wish to update: ");
					user_choice1=add.nextInt();
					while(user_choice1<1 || user_choice1>6)
					{
						System.out.println("Please eneter a correct option");
						System.out.print("> ");
						user_choice1=add.nextInt();
						
					}
					if(user_choice1==1)
					{
						update="brand";
						System.out.print("Please input the brand: ");
						update_choice=add.next();
					}
					else if(user_choice1==2)
					{
						update="model";
						System.out.print("Please input the model: ");
						update_choice=add.next();
					}
					else if(user_choice1==3)
					{
						update="year";
						System.out.print("Please input the year: ");
						update_choiceInt=add.nextInt();
					}
					else if(user_choice1==4)
					{
						update="mileage";
						System.out.print("Please input the mileage: ");
						update_choiceInt=add.nextInt();
						
					}
					else if(user_choice1==5)
					{
						
						update="price";
						System.out.print("Please input the price: ");
						update_choiceInt=add.nextInt();
						
					}
					else if(user_choice1==6)
					{
						update="color";
						System.out.print("Please input the color: ");
						update_choice=add.next();
					}
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","ernesto");
					Statement st = conn.createStatement();
					String sqlstr;
					if(!(update_choice==null)) // check if not empty , if its not we know the variable we want to change is a string
					{
						 sqlstr = "UPDATE cars SET "+update+"="+"'"+update_choice+"'"+"WHERE VIN="+"'"+Vin+"'"+";";
					}
					else  // if its empty then we want to change an Int variable
					{
						 sqlstr = "UPDATE cars SET "+update+"="+"'"+update_choiceInt+"'"+"WHERE VIN="+"'"+Vin+"'"+";";
						
					}
					
					st.executeUpdate(sqlstr);
					System.out.println("The car has been updated, THANK YOU!");
					System.out.println("PLEASE DOUBLE CHECK THE INVENTORY TO SEE IF THE CAR WAS UPDATED");
					System.out.println("press enter to continue back to the menu");
					System.in.read();
					break;
					
					
				}
				
				
				
			}
			else if(user==5)
			{
				//display the users in the database
				System.out.println("THESE ARE THE MEMBERS OF THE DATABASE");
				System.out.println("--------------------------------------");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
				Statement statement =connection.createStatement();
				ResultSet rs= statement.executeQuery("select * from members");
				System.out.printf("%-12s %-12s %-15s %-15s %-14s\n","ID","PASSWORD","FIRST NAME","LAST NAME","EMAIL");
				
				while(rs.next())
				{
					System.out.printf("%-15s",rs.getString("id"));
					System.out.printf("%-15s",rs.getString("password"));
					System.out.printf("%-15s",rs.getString("firstname"));
					System.out.printf("%-15s",rs.getString("lastname"));
					System.out.printf("%-15s",rs.getString("email"));
					System.out.println(" ");
				}
				connection.close();
				System.out.println("Press enter to continue back the menu....");
				System.in.read();
				
			}
			else if(user==6)
			{
				//add a user
				Scanner user1=new Scanner(System.in);
				String id;
				String password = null;
				String second_password;
				String first_name;
				String last_name;
				String email;
				System.out.println("---------------------------------");
				System.out.println("CREATING USER");
				
				System.out.print("Please input your id: ");
				id=user1.next();
				System.out.print("Please input your password(ONLY NUMBERS): ");
				password=user1.next();
				System.out.print("Please input your password again(ONLY NUMBERS): ");
				second_password=user1.next();
				if(!second_password.equals(password))
				{
					while(!second_password.equals(password))
					{
						System.out.println("Please input your password again...they do not match(PLEASE ONLY USE NUMBERS");
						System.out.print(">");
						password=user1.next();
						System.out.println("Enter your password again");
						second_password=user1.next();
						
					}
				}
				System.out.print("Please input your first name: ");
				first_name=user1.next();
				System.out.print("Please input your last name: ");
				last_name=user1.next();
				System.out.print("Please input your email: ");
				email=user1.next();
				System.out.println("Thank you" +" "+first_name+" "+"for signing up!");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","ernesto");
				Statement st = conn.createStatement();
				String sqlstr = "INSERT INTO members VALUES ("+"'"+id+"'"+","+ "'"+password+"'" +","+ "'"+first_name +"'"+","+"'"+last_name +"'"+","+ "'"+email+"'"+");";
				st.executeUpdate(sqlstr);
				
				
			}
			else if(user==7)
			{
				//delete user
				String id;
				Scanner in= new Scanner(System.in);
				System.out.println("DELETE USER");
				System.out.println("-----------------------");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
				Statement statement =connection.createStatement();
				ResultSet rs= statement.executeQuery("select * from members");
				System.out.printf("%-12s %-12s %-15s %-15s %-14s\n","ID","PASSWORD","FIRST NAME","LAST NAME","EMAIL");
				
				while(rs.next())
				{
					System.out.printf("%-15s",rs.getString("id"));
					System.out.printf("%-15s",rs.getString("password"));
					System.out.printf("%-15s",rs.getString("firstname"));
					System.out.printf("%-15s",rs.getString("lastname"));
					System.out.printf("%-15s",rs.getString("email"));
					System.out.println(" ");
				}
				System.out.print("Please enter the ID: ");
				id=in.next();
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","ernesto");
				Statement st = conn.createStatement();
				String sqlstr = "DELETE FROM members WHERE id ="+"'"+ id+"'"+";";
				st.executeUpdate(sqlstr);
				System.out.println("USER DELETED!");
				System.out.println("press enter to continue......");
				System.in.read();
				
				
			}
			else if(user==8)
			{
				//update user
				int choice;
				String id;
				Scanner in= new Scanner(System.in);
				System.out.println("UPDATE USER");
				System.out.println("-----------------------");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
				Statement statement =connection.createStatement();
				ResultSet rs= statement.executeQuery("select * from members");
				System.out.printf("%-12s %-12s %-15s %-15s %-14s\n","ID","PASSWORD","FIRST NAME","LAST NAME","EMAIL");
				
				while(rs.next())
				{
					System.out.printf("%-15s",rs.getString("id"));
					System.out.printf("%-15s",rs.getString("password"));
					System.out.printf("%-15s",rs.getString("firstname"));
					System.out.printf("%-15s",rs.getString("lastname"));
					System.out.printf("%-15s",rs.getString("email"));
					System.out.println(" ");
				}
				System.out.print("Please enter the ID: ");
				id=in.next();
				System.out.println("-----------------------");
				System.out.println("1)Update PassWord");
				System.out.println("2)Update First Name");
				System.out.println("3)Update Last Name");
				System.out.println("4)Update Email");
				System.out.print("Please enter a choice: ");
				choice=in.nextInt();
				String update = null;
				String update_choice = null;
				while(choice<1||choice>4)
				{
					System.out.println("Please enter a correct value");
					System.out.print(">");
					choice=in.nextInt();
				}
				if(choice==1)
				{
					update="password";
					System.out.print("Please input the password: ");
					update_choice=in.next();
				}
				else if(choice==2)
				{
					update="firstname";
					System.out.print("Please enter the  first name:");
					update_choice=in.next();
				}
				else if(choice==3)
				{
					update="lastname";
					System.out.print("Enter the last name: ");
					update_choice=in.next();
				}
				else if(choice==4)
				{
					update="emial";
					System.out.print("Please enter the email: ");
					update_choice=in.next();
					
				}
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root","ernesto");
				Statement st = conn.createStatement();
				String sqlstr;
				if(!(update_choice==null)) // check if not empty , if its not we know the variable we want to change is a string
				{
					 sqlstr = "UPDATE members SET "+update+"="+"'"+update_choice+"'"+"WHERE id="+"'"+id+"'"+";";
					 st.executeUpdate(sqlstr);
				}
				System.out.println("---------------------------------------------------------------------------");
				Connection connection1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/Carmax","root","ernesto");
				Statement statement1 =connection1.createStatement();
				ResultSet ms= statement1.executeQuery("select * from members");
				System.out.printf("%-12s %-12s %-15s %-15s %-14s\n","ID","PASSWORD","FIRST NAME","LAST NAME","EMAIL");
				
				while(ms.next())
				{
					System.out.printf("%-15s",ms.getString("id"));
					System.out.printf("%-15s",ms.getString("password"));
					System.out.printf("%-15s",ms.getString("firstname"));
					System.out.printf("%-15s",ms.getString("lastname"));
					System.out.printf("%-15s",ms.getString("email"));
					System.out.println(" ");
				}
				System.out.println("Press enter to continue............");
				System.in.read();
			}
			else if(user==9)
			{
				
				System.out.println("Logging out...........");
				break;
			
			}
		}
		
	}

}
