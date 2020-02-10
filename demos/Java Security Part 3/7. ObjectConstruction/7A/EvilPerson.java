//Extend Person through inheritance to add age attribute...

public class EvilPerson extends Person
{
	int age=0; 
	
	public EvilPerson(String initName)
	{
		super(initName + " EVIL!"); //Call super class constructor
		age=21;
	}

	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
}