import java.io.File;
import java.io.FileNotFoundException;
import person.Person;
import person.Staff;
import person.Student;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagePeople {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
   	{
		//Load (deserialized) object from data directory into objects in ArrayList
		ArrayList<Person> people = loadPeople();
		String option=null;

		//Main menu loop starts here
		do
		{
			option = showMenu();
		    
			switch(option)
			{
				case "1": //List people
					listPeople(people);
					break;
				case "2": //Add a new person (of any type) to the ArrayList
					addPerson(people);
					break;
				case "3": //Delete someone
					deletePerson(people);
					break;
			}
			    
		} while (!option.equals("0")); //End of main menu loop

	} //End of main
    
	//==========================================================
	//Display menu and get selection from user
	private static String showMenu()
	{
		Scanner s = new Scanner(System.in);

		String option=null;

		System.out.println("\nMENU\n----");
		System.out.println("1. List people");
		System.out.println("2. Add person/student/staff");        
		System.out.println("3. Delete person/student/staff");
		System.out.println("0. Exit");

		option = s.nextLine();

		return option;
	}
    
	//==========================================================
	//List all people of all types
	private static void listPeople(ArrayList<Person> people)
	{
		System.out.println("LIST OF PEOPLE\n--------------");
		    
		for (Person p:people)
		{
			System.out.println(p.toString());
		}       
	}
    
	//==========================================================
	//Add person   
	private static void addPerson(ArrayList<Person> people) throws FileNotFoundException, IOException
	{
		Scanner s = new Scanner(System.in);
		String personType=null;
		String name=null;
		String age=null;

		System.out.println("ADD PERSON/STUDENT/STAFF\n------------------------");

		//Get specific type of person to add
		System.out.println("1. Add Person");
		System.out.println("2. Add Student");
		System.out.println("3. Add Staff");
		personType=s.nextLine();

		//Unconditionally get name and age for people of every type...
		System.out.println("Enter name: ");
		name = s.nextLine();

		System.out.println("Enter age: ");
		age = s.nextLine();

		//Get any extra data as required, add new person (of any type) to ArrayList
		switch(personType)
		{
			case "1": //Add Person
				Person person = new Person(name,age);
				people.add(person);
				break;

			case "2": //Add Student
				String id=null;
				String gpa=null;

				System.out.println("Enter ID: ");
				id = s.nextLine();

				System.out.println("Enter GPA: ");
				gpa = s.nextLine();

				Student student = new Student(name,age,id,gpa);

				people.add(student);

				break;

			case "3": //Add Staff
				String sid=null;
				String salary=null;

				System.out.println("Enter Staff ID: ");
				sid = s.nextLine();

				System.out.println("Enter Salary: ");
				salary = s.nextLine();

				Staff staff = new Staff(name,age,sid,salary);

				people.add(staff);                
				break;
		}

		//Save new object list to data directory (rewrite directory contents)
		savePeople(people);
	}

	//==========================================================
	//Delete person
	private static void deletePerson(ArrayList<Person> people) throws FileNotFoundException, IOException
	{
		String name=null;
		Scanner s = new Scanner(System.in);

		System.out.println("DELETE PERSON\n-------------");
		System.out.print("Enter name of person to delete: ");
		name = s.nextLine();

		//Find object in ArrayList with name matching entered name and remove it from ArrayList
		for (Person p: people)
		{
			if (p.getName().equals(name))
			{
				people.remove(p);
				break;
			}
		}

		//Resave object list to data directory (rewrites directory contents)
		savePeople(people); 
	}

	//==========================================================    
	//==========================================================
	//Saved serialized copy of object to disk
	private static void serializeObject(Object o) throws FileNotFoundException, IOException
	{
		//Get name attribute from object, use as serialized file name (assume no conflicts)

		String name = ((Person)o).getName();

		FileOutputStream fout = new FileOutputStream("../data/" + name + ".ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(o);

		oos.close();
	}
   
	//==========================================================    
	//Load serialized version of object from disk
	private static Object deserializeObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Object o=null;

		FileInputStream fis = new FileInputStream("../data/"+ filename);
		ObjectInputStream in = new ObjectInputStream(fis);
		o=in.readObject();
		in.close();
		fis.close();

		return o;
	}
    
	//==========================================================    
	//Load serialized versions of all objects stored under the data subdirectory
	private static ArrayList<Person> loadPeople() throws IOException, ClassNotFoundException
	{
		ArrayList<Person> people = new ArrayList<Person>();

		File f = new File("../data/"); //Data directory location
		File[] files = f.listFiles(); //Get directory listing of data subdirectory

		//Let list of all files in data directory, deserialize each one back into an object and
		//store reference in ArrayList.
		for (File file: files)
			{
			String filename = file.getName();
			    
			Object o = deserializeObject(filename);
			    
			people.add((Person)o);
		}

		return people;
	}
    
	//==========================================================    
	//Save serialized versions of all objects stored in ArrayList<Person> to disk
	private static void savePeople(ArrayList<Person> people) throws FileNotFoundException, IOException
	{
		//1. Delete all existing files from data directory
		File f = new File("../data/");
		File[] files = f.listFiles();

		for (File file: files)
			file.delete();

		//2. Write out new serialized copies of all objects in ArrayList
		for (Person p: people)
		{
			serializeObject(p);
		}
	}
    
}
