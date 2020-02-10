import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DirTraverse {
    public static void main(String args[]) throws FileNotFoundException
    {
        String filename="", buffer="";
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter filename to open: ");
        filename=s.nextLine();
		
        File f = new File(filename);
        s = new Scanner(f);
        
        while (s.hasNext())
        {
            buffer = s.nextLine();
            System.out.println(buffer);
        }
        
        s.close();
        
    }
}
