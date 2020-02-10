
public final class StudentImmutable {
    //Fields are "private" and "final"
    private final String name;
    private final String id;
    private final double gpa;

    public StudentImmutable() {
        name="n/a";
        id="n/a";
        gpa=0.0;
    }

    public StudentImmutable(String name, String id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }
    
}
