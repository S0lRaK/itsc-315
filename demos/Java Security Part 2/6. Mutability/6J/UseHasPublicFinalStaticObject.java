public class UseHasPublicFinalStaticObject
{
	public static void main(String args[])
	{
		HasPublicFinalStaticObject hpfso = new HasPublicFinalStaticObject();
		
		//Change state of "public static final" object in HasPublicFinalStaticObject
		System.out.println(hpfso.haps.increment());
		System.out.println(hpfso.haps.increment());
		System.out.println(hpfso.haps.increment());
		
	}
}