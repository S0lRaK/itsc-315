public class UsePerson {
  public static void main(String args[]) {
    
    Person person = new Person("betty", "2345");
    showPerson(person);

    EvilPerson evilPerson = new EvilPerson("Demon", "666");
    showPerson(evilPerson);
  }

  private static void showPerson(Person p){
    System.out.println(p.getName() + ", " + p.getPhone());
  }
}
