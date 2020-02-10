
public class CloneMe implements Cloneable {
    private String message="";

    public CloneMe() {
    }

    public CloneMe(String message) {
        this.message=message;
    }

    public String getMessage()
    {
         return message;
    }
    
    @Override 
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
};

