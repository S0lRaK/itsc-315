public class EvilPerson extends Person {

	public EvilPerson(String name, String phone) {
		super(name, "n/a");
	}

	public void setPhone(String phone) {
		super.phone = "n/a";
	}
}
