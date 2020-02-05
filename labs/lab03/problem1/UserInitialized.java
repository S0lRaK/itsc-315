public final class UserInitialized {

	String username="n/a";
	String password="n/a";
	boolean initialized = false;

	public UserInitialized()	{
		initialized = true;
	}

	public UserInitialized(String username, String password) {
		try	{
			if (username == null || password == null)
				throw new IllegalArgumentException("Missing user data");

			this.username = username;
			this.password = password;
			initialized = true;
		}
		catch (IllegalArgumentException e) {
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
    if (initialized)
      return username;
    else
      return null;
	}

	public String getPassword()	{
    if (initialized)
      return password;  
    else
      return null;
	}

	public boolean validate(String username, String password)	{
		boolean valid = false;

		if (this.username.equals(username) && this.password.equals(password))
			valid = true;

		return valid;
	}
}
