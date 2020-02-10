
public class Student {
    private String name="";
    private String id="";
    private double gpa=0.0;
    
    public Student() {
    }

    public Student(String name, String id, double gpa) throws Exception
    {

        try 
        {
            this.name = name;
            this.id = id;
 
            //Something goes wrong...
            if ((1/0)==1)
                throw new Exception("Bogus arithmetic error!");
		
             this.gpa = gpa;
             
       }
       catch (Exception e) 
       {
			//Smother exception
	   }
        
    }
    
    public String getData()
    {
            return name + ", " + id + ", " + gpa;
    }
    
}
