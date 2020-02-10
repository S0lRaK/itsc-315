
public class UseStudentInitialized {
    public static void main(String args[])
    {
        try
        {
           String name="adam";
           String id="1111";
           double gpa=3.8;
           
           System.out.println("Creating student: " + name + "," + id + "," + gpa);
           StudentInitialized s = new StudentInitialized(name,id, gpa);
           System.out.println("Oops: " + s.getData());
        }
        catch (Exception e)
        {
            //Smother exception
            e.printStackTrace();
        }
        
        
    }
}
