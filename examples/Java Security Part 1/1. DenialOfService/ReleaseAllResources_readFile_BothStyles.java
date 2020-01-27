import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ReleaseAllResources_readFile_BothStyles {
    public static void main(String args[])
    {
        //-------------------------------------------------
        //"Old" way to catch exceptions on I/O
        FileInputStream f=null;
        Scanner s=null;
        try
        {
            f = new FileInputStream("input.txt");
            s = new Scanner(f);
            
            while (s.hasNext())
            {
                System.out.println(s.nextLine());
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            s.close();
        }
        
        //-------------------------------------------------
        //Try-with-resources - JDK 1.7 and up
        try (FileInputStream g = new FileInputStream("input.txt"); Scanner h = new Scanner(g); )
        {
            while (h.hasNext())
            {
                System.out.println(h.nextLine());
            }
            
            //h.close(); - NOT NEEDED - file automatically closed for us
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //No need for a finally block either
        
    }
}
