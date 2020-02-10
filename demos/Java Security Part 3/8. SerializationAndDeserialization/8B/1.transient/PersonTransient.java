
import java.io.Serializable;

public class PersonTransient implements Serializable {
	static final long serialVersionUID=1L;
    String name;
    transient String ID; //ID is "important" and must not be serialized!

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

    public PersonTransient() {
        this.name="n/a";
        this.ID="n/a";
    }

    public PersonTransient(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
    
}
