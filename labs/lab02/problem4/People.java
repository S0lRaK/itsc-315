import java.util.ArrayList;

public class People<T>
{
	ArrayList<T> people = new ArrayList<T>();

	public People()
	{}

	public People(T p)
	{
		people.add(p);
	}

	public void addPerson(T p)
	{
		people.add(p);
	}

	public T getPerson(int index)
	{
		return people.get(index);
	}

	public ArrayList<T> getPeople()
	{
		return people;
	}

	//getNumPeople method is commented out, not available.
	/*public int getNumPeople()
	{
		return people.size();
	}*/

}
