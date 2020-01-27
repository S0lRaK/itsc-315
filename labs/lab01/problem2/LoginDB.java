import java.sql.*;
import java.util.*;

public class LoginDB
{
	public static void main(String args[]) throws ClassNotFoundException, Exception
	{
		String database=null;
		String username=null;
		String password=null;
		String loginUser=null;
		String loginPass=null;
		ArrayList<User> users = new ArrayList<User>();
		Scanner s = new Scanner(System.in);

		try
		{
			if (args.length == 5)
			{
				database=args[0];

				loginUser=args[1];

				loginPass=args[2];
				
				username=args[3];

				password=args[4];
			}
			else if (args.length == 0)
			{
				System.out.println("Enter database:");
				database=s.nextLine();

				System.out.println("Enter db login:");
				loginUser=s.nextLine();
				System.out.println("Enter db pass:");
				loginPass=s.nextLine();

				System.out.println("Enter username:");
				username=s.nextLine();
				System.out.println("Enter password:");
				password=s.nextLine();
			}
			else
			{
				throw new Exception();
			}
		}
		catch (Exception e)
		{
			System.out.println("Incorrect amount of arguments entered.");
		}

		User loggingIn = new User(username,password);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, loginUser, loginPass);

			String sql = "select * from users;";

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next())
			{
				String user = rs.getString(1);
				String pass = rs.getString(2);

				User dbUser = new User(user,pass);
				users.add(dbUser);
			}

			rs.close();
			st.close();
			conn.close();

		}
		catch (SQLException e)
		{
			System.out.println("Authentication problem (username and/or password) or incorrect database entered.");
		}

		boolean found=false;
		//Find a match in DB?
		for (User u:users)
		{
			if (u.equals(loggingIn))
				found=true;
		}

		if (found)
			System.out.println("Valid");
		else
			System.out.println("Invalid");

	}

	private static class User
	{
		String username;
		String password;

		public User()
		{
			username=null;
			password=null;
		}

		public User(String username, String password)
		{
			this.username = username;
			this.password = password;
		}

		public void setName(String username)
		{
			this.username=username;
		}
	
		public void setPassword(String password)
		{
			this.password=password;
		}

		public String getUsername()
		{
			return username;
		}

		public String getPassword()
		{
			return password;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (!(obj instanceof User))
				return false;

			User u = (User) obj;

			//No empty strings allowed
			if (u.getUsername().equals("") || u.getPassword().equals(""))
				throw new IllegalArgumentException(toString());

			if (u.getUsername().equals(username) && u.getPassword().equals(password))
				return true;

			return false;
		}

		@Override
		public String toString()
		{
			return username + ":" +password;
		}
		
	}
}





















