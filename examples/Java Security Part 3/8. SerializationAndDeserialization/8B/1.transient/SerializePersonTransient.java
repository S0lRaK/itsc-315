
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializePersonTransient {

    public static void main(String[] args) throws IOException {
        PersonTransient p = new PersonTransient("james","007");
        
        //Save object
        FileOutputStream fout = new FileOutputStream("person.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(p);
        
        oos.close();
        
    }
    
}
