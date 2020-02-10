
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurgeException {
    public static void main(String args[])
    {
        //Try-with-resources - JDK 1.7 and up
        try (FileInputStream g = new FileInputStream("c:/file.txt"); Scanner h = new Scanner(g); )
        {
            while (h.hasNext())
            {
                System.out.println(h.nextLine());
            }
            
            //h.close(); - NOT NEEDED - file automatically closed for us
        }
        catch (FileNotFoundException e)
        {
            //Purge message of "useful content"
            Logger.getLogger(PurgeException.class.getName()).log(Level.SEVERE, "File can not be opened");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }   
}
