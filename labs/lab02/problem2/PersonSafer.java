public final class PersonSafer {
  
  private final String name;
  private final String phone;

  public PersonSafer() {
    name = new String();
    phone = new String();
  }
  
  public PersonSafer(String name, String phone) {
    this.name = name;
    this.phone = phone;
	}

 	public String getName() {	
		return name;
	}

	public String getPhone() {
		return phone;
	}

}
