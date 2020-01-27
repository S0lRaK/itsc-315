
public class StudentInitialized {
    private String name="";
    private String id="";
    private double gpa=0.0;
    private boolean init=false;

    public StudentInitialized() {
        init=true;
    }

    public StudentInitialized(String name, String id, double gpa) throws Exception 
    {

        try 
        {
            this.name = name;
            this.id = id;
            
            //Something goes wrong...
            if ((1/0)==1)
                throw new Exception();
            
             this.gpa = gpa;
             
             init=true;
        }
        catch (Exception e) 
        {}
        
    }
    
    public String getData()
    {
        if (init)
            return name + ", " + id + ", " + gpa;
        else
            return null;
    }
    
}
