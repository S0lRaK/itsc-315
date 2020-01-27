public class UseStudent
{
	public static void main(String args[])
	{
		Person p = new Person("adam","1234");
		Student s = new Student("betty","2345",4.0);

		System.out.println(p.getName() + ", " + p.getPhone());
		System.out.println(s.getName() + ", " + s.getPhone() + ", " + s.getGPA());
	}
}
