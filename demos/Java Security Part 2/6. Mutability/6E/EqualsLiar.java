public class EqualsLiar
{
	public EqualsLiar()
	{
	}
	
	@Override
	public boolean equals(Object o)
	{
		return true; //Always say I'm the same as the other object being compared against (o)
	}
}