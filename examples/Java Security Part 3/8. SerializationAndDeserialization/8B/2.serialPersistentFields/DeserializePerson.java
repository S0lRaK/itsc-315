
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializePerson {
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Person p=null;
        FileInputStream fileIn = new FileInputStream("person.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        p = (Person) in.readObject();
        in.close();
        fileIn.close();
        
        System.out.println("Person: " + p.getName() + "," + p.getID());
    }
}
