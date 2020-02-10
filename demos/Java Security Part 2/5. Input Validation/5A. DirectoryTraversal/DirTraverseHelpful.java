import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// Questions
// 1. Is this black list or white list?
// 2. Can you find the bug by reading the code?  What's the exploit?
public class DirTraverseHelpful {
    public static void main(String args[]) throws FileNotFoundException
    {
        String filename="", buffer="";
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter filename to open: ");
        filename=s.nextLine();
		
		//Don't allow paths to be included in the file name, helpfully remove the file path and use just the file name at the end
		if (filename.indexOf(":")!=-1 || filename.indexOf("..")!=-1 || filename.indexOf("\\")!=-1 || filename.indexOf("/")!=-1)
		{

			if (filename.lastIndexOf("\\")!=-1)
				filename = filename.substring(filename.lastIndexOf("\\")+1);
			else if (filename.lastIndexOf("/")!=-1)
				filename = filename.substring(filename.lastIndexOf("/")+1);
				
		}
		
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
