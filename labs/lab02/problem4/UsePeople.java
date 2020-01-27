public class UsePeople
{
	public static void main(String args[])
	{
		People<Person> p = new People<Person>();

		p.addPerson(new Person("adam","1234"));
		p.addPerson(new Person("betty","2345"));

		//System.out.println("Number of people: " + p.getNumPeople());
		System.out.println("1) " + p.getPerson(0).getName() + ", " + p.getPerson(0).getPhone());
		System.out.println("2) " + p.getPerson(1).getName() + ", " + p.getPerson(1).getPhone());
	}
}

