public class UsePerson
{
	public static void main(String args[])
	{
		Person p = Person.getInstance("adam");
		System.out.println("Name: " + p.getName());
		
		//Uncomment this to test Person error checking in constructor.
		//p = Person.getInstance(null);
		//System.out.println("Name: " + p.getName());
	}
}	