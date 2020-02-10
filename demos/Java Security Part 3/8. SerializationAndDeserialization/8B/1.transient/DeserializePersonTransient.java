
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializePersonTransient {
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        PersonTransient p=null;
        FileInputStream fileIn = new FileInputStream("person.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        p = (PersonTransient) in.readObject();
        in.close();
        fileIn.close();
        
        System.out.println("Person: " + p.getName() + "," + p.getID());
    }
}
