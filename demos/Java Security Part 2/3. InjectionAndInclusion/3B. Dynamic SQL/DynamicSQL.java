//Command line to run: java -classpath .:./mysql-connector-java-5.1.23-bin.jar DynamicSQL

import java.sql.*;
import java.util.Scanner;

public class DynamicSQL
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","password");
			
			String username=null;
			
			System.out.print("Enter username to find: ");
			username=s.nextLine(); // Try the following input for the username: ' or 1=1 or '
			
			String sql="select * from users where username='" + username + "';"; //Concatentation of user input into SQL statement(!!)
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				System.out.println("Username: " + rs.getString(1) + "\tPassword: " + rs.getString(2));
			}
			
			rs.close();
			st.close();
			conn.close();

		}
		catch(SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
