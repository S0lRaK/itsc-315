public class Person
{
	String name;
	
	//Use a static "factory" method to create, initialize and return a new instance of Person.
	//(You can't create a static constructor in Java, i.e. "public static Person() {..." is not allowed).
	public static Person getInstance(String initName)
	{
		return new Person(initName);
	}
	
	protected Person(String initName) //NOTE: PROTECTED not public
	{
		//Can't have a null name...
		if (initName == null)
			throw new IllegalArgumentException("Person name missing!");
		
		name=initName;
	}
	
	public String getName()
	{
		return name;
	}
}