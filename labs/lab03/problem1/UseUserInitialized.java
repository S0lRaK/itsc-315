public class UseUserInitialized {

  public static void main(String[] args) {
    try {
      UserInitialized ui1 = new UserInitialized("adam", "pass");
      System.out.println("1) Name: " + ui1.getUsername() + ", Password: " + ui1.getPassword());

      UserInitialized ui2 = new UserInitialized("bill", null);
      System.out.println("2) Name: " + ui2.getUsername() + ", Password: " + ui2.getPassword());

      UserInitialized ui3 = new UserInitialized("bill", "password");
      System.out.println("3) Name: " + ui3.getUsername() + ", Password: " + ui3.getPassword());
    }  catch (Exception e) {
      e.printStackTrace();
    }
  }
}