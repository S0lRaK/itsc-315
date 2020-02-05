import java.io.*;

public class DeserializeUserTransient {
  public static void main(String args[]) {
    UserTransient user = null;

    try {
      FileInputStream fis = new FileInputStream("usertransient.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      user = (UserTransient) ois.readObject();
      ois.close();
      fis.close();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println("Name: " + user.getUsername());
    System.out.println("Password: " + user.getPassword());
  }
}
