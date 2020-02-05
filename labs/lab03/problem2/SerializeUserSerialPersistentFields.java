import java.io.*;

public class SerializeUserSerialPersistentFields {
  public static void main(String args[]) {
    UserSerialPersistentFields user = new UserSerialPersistentFields("adam", "pass");

    try {
      FileOutputStream fos = new FileOutputStream("user_serial_persistent_fields.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(user);
      oos.close();
      fos.close();
      System.out.println("User object written to user_serial_persistent_fields.ser");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
