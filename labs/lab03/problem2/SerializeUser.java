import java.io.*;

public class SerializeUser
{
	public static void main(String args[])
	{
		User user = new User("adam","pass");

		try
		{
			FileOutputStream fos = new FileOutputStream("user.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.close();
			fos.close();
			System.out.println("User object written to user.ser");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
