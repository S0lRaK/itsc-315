import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

public class DeserializePersonSaferSerial
{
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		PersonSaferSerial pss = null;
		
		FileInputStream fileIn = new FileInputStream("saferperson.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        pss = (PersonSaferSerial) in.readObject();
        in.close();
        fileIn.close();
        
        System.out.println("PersonSaferSerial: " + pss.getFirstName() + "," + pss.getLastName() + "," + pss.getAge());
	}
}
