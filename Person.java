/*
* Cloneable means the object is able to be copied.
*/
class Person implements Cloneable {

    private String firstName;

    private String lastName;

    private int age;
    
    private double weight;

    public Person() {
        firstName = "SUPER";
        lastName = "SECRET";
        age = -9999999;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String toString() {
        return "My name is " + firstName + " " + lastName + " and I am " + age + " years old.";
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    /**
     * Determines the equality of the objects.
     * @author Lord Pheffenuise
     * @param b Person to check equivalence with.
     * @return Boolean value of equivalence.
     */
    public boolean equals(Person b) {
        if(this.firstName.equals(b.getFirstName()) 
                && this.lastName.equals(b.getLastName())
                && this.age == b.getAge()) {
                    return true;
        } else { return false; }
    }

    public static void main(String args[]) {
        Person p = new Person();
        Person p2 = new Person("Gallahad", "of Camelot", 35);
        Person p3 = new Person("Lancelot", "of Camelot", 46);
        try {
            Person p4 = p3.clone();
            System.out.println(p3.equals(p4));
        } catch(CloneNotSupportedException c) { System.out.println(c); }

        System.out.println(p2);
        System.out.println(p);
    }
}
