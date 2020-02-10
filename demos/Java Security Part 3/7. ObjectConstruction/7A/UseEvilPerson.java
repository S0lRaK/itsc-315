public class UseEvilPerson
{
	public static void main(String args[])
	{
		Person p = Person.getInstance("adam");
		System.out.println("Name: " + p.getName());
		
		EvilPerson p2 = new EvilPerson("betty");
		System.out.println("Name: " + p2.getName() + " Age: " + p2.getAge());
		
	}
}	