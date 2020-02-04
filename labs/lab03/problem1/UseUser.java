public class UseUser
{
	public static void main(String args[])
	{
		User u1=new User();
		User u2=new User("adam","pass");
		User u3=new User(null, null);

		System.out.println("1: Name: " + u1.getUsername() + ", Password: " + u1.getPassword());

		System.out.println("2: Name: " + u2.getUsername() + ", Password: " + u2.getPassword());

		System.out.println("3: Name: " + u3.getUsername() + ", Password: " + u3.getPassword());

	}
}
