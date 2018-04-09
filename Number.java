abstract class Num<T> {
    
    private T num;

    public static void main(String args[]) {

    }
}

class Complex {

}

class Fraction {

}

interface NumberHelper<T> {
    public T square();
    public default String type() {
        return "I am a " + this.getClass().getName();
    }
}
