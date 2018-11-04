/*
 * NAME:Ernesto Valdez
 * DATE: 11-8-16
 * DESCRIPTION: ASKS THE FOR TO INPUT A CHOICE FROM A MENU, THE USER CAN CHOOSE TO LOGIN,CREATE ACCOUNT OR LOG OUT,
 * IF THE USER CHOOSES TO LOGIN THEY HAVE TO INPIT THEIR IFORMATION AND AFTER THEY HAVE DONE SO SUCCESSFULLY THEY CAN
 * ACCESSS THE USER MENU AND IF THE USER DOES NOT HAVE AN COOUNT THEN THEY CAN CREATE ONE BY INPUT SOME INFORMATION
 * AND THE PROGRAM STORES THEIR IFORMATION INTO A DATABASE WHICH IS ACCESSED WHEN A USER SIGNS IN TO CHECK IF THEY ARE USERS
 * ONCE THE USER CAN LOG IN THEY CAN ACCESS SEVERAL OTHER MENUS BY INPUTTING THE PROPER ANSWERS
 * */


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,ClassNotFoundException, SQLException, IOException
	{ 
		
		System.out.println("Hello Welcome to Carmax");
		login menu= new login(); // create the menu 
		Scanner scan=new Scanner(System.in);
	
			
	//NOTE: each of the functions inside this main loop for the other choices has the same structure as this main loop
	// so each of the function being called from the login menu class has similar loops that execute their own code until the user breaks
	// out of those menus
	while(true)// loop that continues the program until the user decides to exit out with the third option
	{  /////////////////////////////////
		//          MAIN MENU        //
		//////////////////////////////////
		 //display the menu so the user can choose an option
		menu.display_main_menu();
		int user_option= scan.nextInt();
		// check the user option
		while(user_option <1 || user_option >3)
		{
			System.out.println("Enter a correct option");
			user_option=scan.nextInt();
		}
		if(user_option==1)
		{
			
			//////////////////////////
			//       USER MENU     ///
			/////////////////////////	
			int menuType=menu.login();
			if(menuType==1) // calls the method to login the user
			{
				menu.display_userMenu();
			}
			else if(menuType==3)
			{
				menu.admin_account();
			}
			
		}
		else if(user_option==2)
		{
			
			
			/////////////////////////
			//  MAKE ACCOUNT MENU  //
			/////////////////////////
			menu.create_account(); // calls the method
		}
		else if(user_option==3)
		{
			
			///////////////////////
			//     EXIT          //
			///////////////////////
			
			break; //break out of the main loop
		}
				
				
			
	}// the main program while loop to keep running the menu until the user decided to exit out	
		
		System.out.println("Goodbye!!!");
		
		
		
		scan.close(); //close the scanner
		
	}

}
