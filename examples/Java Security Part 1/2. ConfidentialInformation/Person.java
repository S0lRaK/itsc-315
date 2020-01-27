public class Person
{
	private String username;
	private String password;
	
	public Person()
	{
		username="";
		password="";
	}
	
	public Person(String username, String password)
	{
		this.username=username;
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
	
	//Handy toString(), for debugging...
	public String toString()
	{
		return getUsername() + "," + getPassword();
	}
}