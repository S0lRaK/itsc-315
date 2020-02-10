public class UseEqualsLiar
{
	public static void main(String args[])
	{
		EqualsLiar el1 = new EqualsLiar();
		EqualsLiar el2 = new EqualsLiar();
		
		System.out.println("References: el1=" + el1 + " el2=" + el2);
		
		System.out.println("el1 equals el2: " + el1.equals(el2));
	}
}