import java.util.*;
public class Menu {
	
	// the main menu or first menu that it displays
	public void display_loginMenu()
	{
		//int ans=0;
		//Menu menu=new Menu();
		//Scanner in=new Scanner(System.in);
		System.out.println("@@@@@@<|Main Menu|>@@@@@@");
		System.out.println("1. Login");
		System.out.println("2. Signup");
		System.out.println("3. Exit");
		System.out.print("please input your choice: ");
		/*ans=in.nextInt();
		if(ans>3 || ans<1)
		{
			System.out.println("Errror!!! THATS THE WRONG NUMBER!!");
			menu.display_loginMenu();
		}*/
		
	
		
	}
	// show this menu when you successfully log in
	public void display_userMenu()
	{
		
			System.out.println("*****<|Member Menu|>*****");
			System.out.println("1. Utility");
			System.out.println("2. Game");
			System.out.println("3. Multimedia");
			System.out.println("4. Update Profile");
			System.out.println("5. Log out");
			System.out.print(": ");
		
	}
	// utility menu 
	public void display_utilityMenu()
	{
	
		System.out.println("~~~~~~~~~This is not yet implemented~~~~~~~~~~`");
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}
	// game menu
	public void display_Game()
	{
		System.out.println("~~~~~~~This is not yet implemented~~~~~~~~~");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	// multimedia menu
	public void display_muiltimedia()
	{
		System.out.println("~~~~~~~This is not yet implemented yet~~~");
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	// profile menu
	public void display_profile()
	{
		System.out.println("*****|Profile Menu|*****");
		System.out.println("1.Display profile");
		System.out.println("2.Change password");
		System.out.println("3.Change first name");
		System.out.println("4.Change last name");
		System.out.println("5.Change email");
		System.out.println("6.Exit");
		System.out.print(">"); 
	}
	





	

}
