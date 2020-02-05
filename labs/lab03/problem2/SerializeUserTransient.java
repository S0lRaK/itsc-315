import java.io.*;

public class SerializeUserTransient {
  public static void main(String args[]) {
    UserTransient user = new UserTransient("adam", "pass");

    try {
      FileOutputStream fos = new FileOutputStream("usertransient.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(user);
      oos.close();
      fos.close();
      System.out.println("User object written to usertransient.ser");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
