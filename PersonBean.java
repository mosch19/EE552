class PersonBean extends Person {

    public PersonBean(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public String toString() {
        return super.toString();
    }
    
    public static void main(String args[]) {
        PersonBean p = new PersonBean("Brave Sir Robin", "of the silly place.", 36);
        System.out.println(p);
    }
    
    public class UsingReflection {
        public void main(String args[]) {
            PersonBean b = new PersonBean("Steward", "Denethor", 87);
        }
    }
}
