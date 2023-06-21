package vtiger.genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtility 
{
	Connection connection;
	public String fetchDataFromDataBase(String sqlQuery, int cellNo) throws SQLException
	{
		ResultSet result = connection.createStatement().executeQuery(sqlQuery);
		
		while(result.next())
		{
			return result.getString(cellNo);
		}return "";
	}
	
	public void updateDataIntoDataBase(String sqlQuery) throws SQLException
	{
		int result = connection.createStatement().executeUpdate(sqlQuery);
		if(result==1)
		{
			System.out.println("The database has been updated.");
		}
		else
			System.out.println("The database has not been updated.");
	}
}
