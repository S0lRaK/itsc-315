import java.io.*;

public class DeserializeUserSerialPersistentFields {
  public static void main(String args[]) {
    UserSerialPersistentFields user = null;

    try {
      FileInputStream fis = new FileInputStream("user_serial_persistent_fields.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      user = (UserSerialPersistentFields) ois.readObject();
      ois.close();
      fis.close();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println("Name: " + user.getUsername());
    System.out.println("Password: " + user.getPassword());
  }
}
