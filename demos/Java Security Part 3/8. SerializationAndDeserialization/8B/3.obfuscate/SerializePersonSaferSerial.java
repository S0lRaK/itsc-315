import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializePersonSaferSerial
{
	public static void main(String args[]) throws IOException
	{
		PersonSaferSerial pss = new PersonSaferSerial("adam","ant",20);
		
		//Save object
        FileOutputStream fout = new FileOutputStream("saferperson.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(pss);
        
        oos.close();
	}
}
	