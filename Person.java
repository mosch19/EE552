class Person {

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

    public static void main(String args[]) {
        Person p = new Person();
        Person p2 = new Person("Gallahad", "of Camelot", 35);
        System.out.println(p2);
        System.out.println(p);
    }
}
