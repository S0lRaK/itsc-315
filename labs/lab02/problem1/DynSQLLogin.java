//http://www.unixwiz.net/techtips/sql-injection.html

import java.sql.*;
import java.util.*;

public class DynSQLLogin
{
	public static void main(String args[]) throws ClassNotFoundException
	{
		String username=null;
		String password=null;
		Scanner s=new Scanner(System.in);
		boolean valid=false;

		System.out.println("Enter username:");
		username=s.nextLine();

		System.out.println("Enter password:");
		password=s.nextLine();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//Note the connection string below...(!)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?allowMultiQueries=true", "root", "password");

			String sql = "select * from users where username='" + username + "' and password='" + password + "';";
			System.out.println(sql);

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next())
			{
				valid=true;
			}

			rs.close();
			st.close();
			conn.close();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		if (valid)
			System.out.println("Valid");
		else
			System.out.println("Invalid");

	}
}
