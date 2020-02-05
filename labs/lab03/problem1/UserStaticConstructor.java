public final class UserStaticConstructor {

  String username = "n/a";
  String password = "n/a";

  public static UserStaticConstructor getInstance(String username, String password) {

    return new UserStaticConstructor(username, password);
  }

  protected UserStaticConstructor(String username, String password) {

    if (username == null || password == null) {
      throw new IllegalArgumentException("Missing user data");
    }

    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}