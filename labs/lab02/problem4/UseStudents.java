import java.util.ArrayList;

public class UseStudents
{
	public static void main(String args[])
	{
		Students<Student> students = new Students<Student>();

		students.addStudent(new Student("adam","1234",3.5));
		students.addStudent(new Student("betty","2345",4.0));

		//How many students in the list before?
		System.out.println("Number of students before: " + students.getNumStudents());

		//Get reference to internal ArrayList of all Student objects (inherited method from People)
		Object allStudents = (Object)students.getPeople(); 
		//Clear all students from list (should not be able to do this, according to API of Students)!
		((ArrayList<Person>)allStudents).clear();

		System.out.println("Number of students after: " + students.getNumStudents());
	}
}
