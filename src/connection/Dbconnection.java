package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	public static Connection connect()
	{
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aawas_yojana","root","");
			
		} catch (ClassNotFoundException e)
		{
			System.out.println("nhi");
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			System.out.println("bilkul nhi");
			e.printStackTrace();
		}
		return (Connection) con;
	}
}
