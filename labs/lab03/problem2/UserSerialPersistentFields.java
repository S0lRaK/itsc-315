import java.io.ObjectStreamField;
import java.io.Serializable;

public final class UserSerialPersistentFields implements Serializable {
  private static final long serialVersionUID = 1L;
  String username = "n/a";
  String password = "n/a";
  private static final ObjectStreamField[] serialPersistentFields = {
    new ObjectStreamField("username", String.class)
  };

  public UserSerialPersistentFields() {  }

  public UserSerialPersistentFields(String username, String password) {
    try {
      if (username == null || password == null)
        throw new IllegalArgumentException("Missing user data");

      this.username = username;
      this.password = password;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public boolean validate(String username, String password) {
    boolean valid = false;

    if (this.username.equals(username) && this.password.equals(password))
      valid = true;

    return valid;
  }
}
