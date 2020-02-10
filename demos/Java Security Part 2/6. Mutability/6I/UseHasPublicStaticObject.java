public class UseHasPublicStaticObject
{
	public static void main(String args[])
	{
		HasPublicStaticObject hpso = new HasPublicStaticObject();
		
		hpso.haps.method(); //OK
		
		//Now substitute public static object with new (evil) subclass of expected object type
		EvilClass ec = new EvilClass();
		hpso.haps = ec;
		
		hpso.haps.method(); //Not OK
		
	}
}