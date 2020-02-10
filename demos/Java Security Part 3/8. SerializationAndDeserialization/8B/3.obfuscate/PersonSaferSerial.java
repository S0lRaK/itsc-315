public class PersonSaferSerial implements java.io.Serializable
{

    private String firstName;
    private String lastName;
    private int age; //Age must be "secret" in serialized object...
	
    public PersonSaferSerial(String fn, String ln, int a)
    {
        this.firstName = fn; 
		this.lastName = ln; 
		this.age = a;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    
    public void setFirstName(String value) { firstName = value; }
    public void setLastName(String value) { lastName = value; }
    public void setAge(int value) { age = value; }

    private void writeObject(java.io.ObjectOutputStream stream)
        throws java.io.IOException
    {
        // "Encrypt" the sensitive data
        age = age << 2; //Move bits left (encode)
		System.out.println(age);
        stream.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream stream)
        throws java.io.IOException, ClassNotFoundException
    {
        stream.defaultReadObject();

        // "Decrypt" the sensitive data
        age = age >> 2; //Move bits right (decode)
    }
    
    public String toString()
    {
        return "[Person: firstName=" + firstName + 
            " lastName=" + lastName +
            " age=" + age + "]";
    }      

}