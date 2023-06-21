package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ToFetchDataFromDataBase
{
	public static void main(String[] args) throws SQLException 
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root","root");// Here url, username, password are sent
		
		ResultSet result = connection.createStatement().executeQuery("select * from lead;");
		
		while(result.next())
		{
			System.out.println("first name-"+result.getString(1));
			System.out.println("last name->"+result.getString(2));
		}
		
		
	}
	
}
