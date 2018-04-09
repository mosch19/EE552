abstract class Pizza {
    protected String flavor;
    Pizza(String flavor) {
        this.flavor = flavor;
    }
    public abstract String type();
    public static void main(String args[]) {
        NYPizza ny = new NYPizza("Pepperoni", .02);
        DeepDish d = new DeepDish("Sausage", false);
        System.out.println(ny.type());
        System.out.println(d.type());
    }
}

class NYPizza extends Pizza {
    private double thin;
    NYPizza(String flavor, double thickness) {
        super(flavor);
        this.thin = thickness;
    }
    public String type() { return "I am from NY and " + thin + " inches thick."; }

}

class DeepDish extends Pizza {
    boolean amIPizza;
    DeepDish(String flavor, boolean amIPizza) {
        super(flavor);
        this.amIPizza = amIPizza;
    }
    public String type() { 
        String msg;
        if(amIPizza) {
            msg = "certainly";
        } else {
            msg = "not";
        }
        return "I am from Chicago and I am " + msg + " pizza.";
    }

}
