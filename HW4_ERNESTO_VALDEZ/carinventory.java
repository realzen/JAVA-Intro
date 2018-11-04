/*
 * NAME: ERNESTO VALDEZ
 * DATE: 12/5/16
 * HOMEWORK #4
 * 
 * 
 * 
 * 
 */


import java.sql.*;
import javax.swing.JOptionPane;

public class carinventory
{
	public carinventory()
	{
		
	}
	public Object[][] getTable0() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root", "ernesto");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from cars");

		Object[][] data = new Object[10][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
		connection.close();
		return data;
	}
	
	public Object[][] getTable1(String vin, String brand, String model, String year, String mileage, String price, String color) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
	
	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root", "ernesto");
		Statement statement = connection.createStatement();
		String var;
		
		if(vin.equals(""))
		{
			vin = "%";
		}
		if(brand.equals(""))
		{
			brand = "%";
		}
		if(model.equals(""))
		{
			model = "%";
		}
		if(color.equals(""))
		{
			color = "%";
		}
		var = "select * from cars where vin like '"+vin+"' AND brand like '"+brand+"' AND model like '"+model+"' AND color like '"+color+"';";
		if(!year.equals(""))
		{
			var = var + " AND year = "+year;
		}
		if(!mileage.equals(""))
		{
			var = var + " AND mileage = "+mileage;
		}
		if(!price.equals(""))
		{
			var = var + " AND price = "+price;
		}
		var = var + ";";
		
		
		ResultSet rs = statement.executeQuery(var);
		System.out.println(rs);
		Object[][] data = new Object[10][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
		
		connection.close();
		return data;
	}
	public Object[][] getTable2(String vin) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root", "ernesto");
		Statement statement = connection.createStatement();
		String var2;
		if(vin.equals(""))
		{
			JOptionPane.showMessageDialog(null, "There is no VIN number given");
		}
		
		var2 = "delete from cars where vin = '"+vin+"';";
		int r = statement.executeUpdate(var2);
		if(r != 0)
		{
			System.out.print("\nSuccessfully deleted!\n");
		}
		var2 = "select * from cars;";
		ResultSet rs = statement.executeQuery(var2);
		Object[][] data = new Object[10][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
			
		connection.close();
		return data;
	}
	public Object[][] getTable3(String vin, String brand, String model, String year, String mileage, String price, String color) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root", "ernesto");
		Statement statement = connection.createStatement();
		String var3 = "UPDATE cars SET ";
		
		if(!brand.equals("") && model.equals("") && color.equals("") && year.equals("") && mileage.equals("") && price.equals(""))
		{
			var3 = var3 + "brand = '" + brand + "'";
		}
		
		else if(!brand.equals(""))
			
		{
			var3 = var3 + "brand = '" + brand + "', ";
		}
		
		if(!model.equals("") && color.equals("") && year.equals("") && mileage.equals("") && price.equals(""))
		{
			var3 = var3 + "model = '" + model + "'";
		}
		
		else if(!model.equals(""))
		{
			var3 = var3 + "model = '" + model + "', ";
		}
		
		if(!color.equals("") && year.equals("") && mileage.equals("") && price.equals(""))
		{
			var3 = var3 + "color = '" + color + "'";
		}
		
		else if(!color.equals(""))
		{
			var3 = var3 + "color = '" + color + "', ";
		}
		
		if(!year.equals("") && mileage.equals("") && price.equals(""))
		{
			var3 = var3 + "year = " + year;
		}
		
		else if(!year.equals(""))
		{
			var3 = var3 + "year = '" + year + "', ";
		}
		
		if(!mileage.equals("") && price.equals(""))
		{
			var3 = var3 + "mileage = " + mileage;
		}
		
		else if(!mileage.equals(""))
		{
			var3 = var3 + "mileage = '" + mileage +"', ";
		}
		
		if(!price.equals(""))
		{
			var3 = var3 + "price = " + price;
		}
		
		if(vin.equals(""))
		{
			JOptionPane.showMessageDialog(null, "There is no VIN number given");
		}
		
		//  ELSE DO THIS
		else
		{
			var3 = var3 + " where vin = '"+vin+"';";
			
			int r = statement.executeUpdate(var3);
			if(r != 0)
			{
				System.out.println("Sucessfully updated!");
			}
		}
		
		var3 = "select * from cars;";
		ResultSet rs = statement.executeQuery(var3);
		Object[][] data = new Object[10][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
		
		connection.close();
		return data;
	}
	public Object[][] getTable4(String vin, String brand, String model, String year, String mileage, String price, String color) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		System.out.println("vin: "+vin);
		System.out.println("brand: "+brand);
		System.out.println("model: "+model);
		System.out.println("year: "+year);
		System.out.println("mileage: "+mileage);
		System.out.println("price: "+price);
		System.out.println("color: "+color);
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax","root", "ernesto");
		Statement statement = connection.createStatement();
		String var4;
		
		// DISPLAYS  IF ITS MISSING SOMETHING
		if(vin.equals("")||brand.equals("")||model.equals("")||color.equals("")||year.equals("")||mileage.equals("")||price.equals(""))
		{
			JOptionPane.showMessageDialog(null, "MISSING INFORMATION CHECK AGAIN");
		}
		
		// INPUT THE INFORMATION IF THEY DID INPIT EVERYTHING
		// THEY NEEDED TO PUT 
		if(!vin.equals("") && !brand.equals("") && !model.equals("") && !color.equals("") && !year.equals("") && !mileage.equals("") && !price.equals(""))
		{
			var4 = "INSERT INTO cars values ('"+vin+"', '"+brand+"', '"+model+"', '"+year+"', '"+mileage+"', '"+price+"', '"+color+"');";
			System.out.println(var4);
			int r = statement.executeUpdate(var4);
			if(r != 0)
			{
				System.out.println("Successfully added!");
			}
		}
		var4 = "select * from cars;";
		
		ResultSet rs = statement.executeQuery(var4);
		Object[][] data = new Object[10][7];
		int count=0;
		while(rs.next())
		{
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getInt("year");
			data[count][4] = rs.getInt("mileage");
			data[count][5] = rs.getInt("price");
			data[count][6] = rs.getString("color");
			count++;
		}
		
		connection.close();
		return data;
	}
}

