
public class Person {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
		if (name == null || name.length() < 1)
			throw new IllegalArgumentException("Invalid name");
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
		if (id == null || id.length() < 1)
			throw new IllegalArgumentException("Invalid ID");
        this.id = id;
    }

    public Person() {
        this.name="n/a";
        this.id="n/a";
    }

    public Person(String name, String id) {
		setName(name);
		setId(id);
    }
    
    
}
