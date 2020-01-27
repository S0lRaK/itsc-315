
import java.io.Serializable;

public class Person implements Serializable {
    String name;
    String ID;

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Person() {
        this.name="n/a";
        this.ID="n/a";
    }

    public Person(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
    
}
