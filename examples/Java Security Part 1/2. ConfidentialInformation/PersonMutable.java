
public class PersonMutable
{
	private StringBuffer username;
	private StringBuffer password;
	
	
	public PersonMutable()
	{
		this.username=new StringBuffer();
		this.password=new StringBuffer();
	}
	
	public PersonMutable(String username, String password)
	{
		this.username=new StringBuffer();
		this.password=new StringBuffer();
		
		this.username.append(username);
		this.password.append(password);
	}
	
	public void clear()
	{
		this.username.setLength(0); //Clear username
		this.password.setLength(0); //Clear password
	}
	
	public void setUsername(String username)
	{
		this.username.setLength(0);
		this.username.append(username);
	}
	
	public void setPassword(String password)
	{
		this.password.setLength(0);
		this.password.append(password);
	}
	
	public String getUsername()
	{
		return this.username.toString();
	}
	
	public String getPassword()
	{
		return this.password.toString();
	}
}