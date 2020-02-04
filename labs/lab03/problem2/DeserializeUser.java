import java.io.*;

public class DeserializeUser
{
	public static void main(String args[])
	{
		User user = null;

		try
		{
			FileInputStream fis = new FileInputStream("user.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			user = (User) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(IOException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		System.out.println("Name: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());


	}
}
