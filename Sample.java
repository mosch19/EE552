class Sample {
    private int x;

    Sample(int x) {
        this.x = x;
    }

    private void g() {
        System.out.println("haha");
    }

    public String toString() {
        return "Haha what: " + this.x;
    }

    public static void main(String args[]) {
        Sample x = new Sample(4);
        System.out.println(x);
    }
}

// I cannot be instantiated...
abstract class Hurray {
    private int x;
    public Hurray() {

    }
}

// I can inherit from 
class yeah extends Hurray {
    
}
