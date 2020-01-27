import java.util.ArrayList;

public class Students<T> extends People<T>
{

	public Students()
	{
	}

	public Students(T p)
	{
		people.add(p);
	}

	//API changes from People superclass...
	public void addStudent(T p)
	{
		people.add(p);
	}

	public T getStudent(int index)
	{
		return people.get(index);
	}


	//Additional method for subclass
	public int getNumStudents()
	{
		return people.size();
	}

}
