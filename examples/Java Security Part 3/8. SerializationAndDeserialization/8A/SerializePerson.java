
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializePerson {

    public static void main(String[] args) throws IOException {
        Person p = new Person("adam","1111");
        
        //Save object
        FileOutputStream fout = new FileOutputStream("person.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(p);
        
        oos.close();
        
    }
    
}
