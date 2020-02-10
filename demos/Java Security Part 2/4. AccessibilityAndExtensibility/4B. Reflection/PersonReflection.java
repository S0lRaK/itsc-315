
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Class;


public class PersonReflection {
    public static void main(String args[])
    {
        try {
            Class<?> p  = Class.forName("Person");
            Object o = p.newInstance();
            
            Class[] cArg = new Class[1];
            cArg[0]=String.class;

            Method m = p.getDeclaredMethod("setName",cArg);

            m.invoke(o,"Bob");

            System.out.println(m.toString());
            System.out.println(((Person)o).getName());
            
            //List all methods 
            for (Method n: p.getDeclaredMethods()) //local only
            //for (Method n: p.getMethods()) //includes inherited
            {
                    System.out.println(p.getName() + "." + n.getName());
            }
			
            //List all fields 
            for (Field f: p.getDeclaredFields())
            {
                    System.out.println(p.getName() + "." + f.getName());
            }
			
			// ((Person)o).setName("");  // this would throw an exception
			
			// get the field name
			Field f = Person.class.getDeclaredField("name");
			f.setAccessible(true);
			f.set(o, null);   // change the private variable directly
			System.out.println(((Person)o).getName());
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        
        
    }
}
