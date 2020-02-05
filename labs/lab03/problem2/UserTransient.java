import java.io.Serializable;

public final class UserTransient implements Serializable {
  private static final long serialVersionUID = 1L;
  String username = "n/a";
  transient String password = "n/a";

  public UserTransient() {  }

  public UserTransient(String username, String password) {
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
