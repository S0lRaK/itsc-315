public final class Student {

  private final Person person;
  private final float gpa;

  public Student() {
    person = new Person();
    gpa = 0.0f;
  }

  public Student(String name, String phone, double gpa) {
    person = new Person(name, phone);
    this.gpa = (float)gpa;
  }

  public String getName() {
    return person.getName();
  }

  public String getPhone() {
    return person.getPhone();
  }

  public float getGPA() {
    return this.gpa;
  }
}