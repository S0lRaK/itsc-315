import java.lang.reflect.Field;

public class UseStudentImmutable {
    public static void main(String args[]) throws Exception
    {
        StudentImmutable si = new StudentImmutable("adam","1111",3.8);
        
        System.out.println(si.getName() + "," + si.getId() + "," + si.getGpa());
		
		// Careful though!  Without a security manager, you can still change final fields
		Field f = StudentImmutable.class.getDeclaredField("name");
		f.setAccessible(true);
		f.set(si, "abe");
		System.out.println(si.getName());
    }
}
