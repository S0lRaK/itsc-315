public class Person
{
	String name;
	String phone;

	public Person()
	{
		name = new String();
		phone = new String();
	}

	public Person(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getName()
	{	
		return name;
	}

	public String getPhone()
	{
		return phone;
	}

}
