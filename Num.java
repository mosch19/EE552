abstract class Num<T> {
    
    protected T num;

    Num(T num) {
        this.num = num;
    }

    public abstract String numType();

    public abstract String print();

    public static void main(String args[]) {
        Complex c = new Complex(1.2, -5.6);
        System.out.println(c.numType());
        System.out.println(c.print());
        System.out.println(c.type());

        Fraction f = new Fraction(-2, 3);
        System.out.println(f.numType());
        System.out.println(f.print());
        System.out.println(f.type());
    }
}

class Complex extends Num<Double> implements NumberHelper<Double> {
    double imag;

    Complex(double real, double imag) {
        super(real);
        this.imag = imag;
    }

    public String numType() { return this.getClass().getTypeName(); }

    public String print() { return "(" + super.num + "," + this.imag + "i)"; }

    public Double square() { return super.num * super.num; }
}

class Fraction extends Num<Integer> implements NumberHelper<Integer> {
    int den;

    Fraction(int num, int den) {
        super(num);
        this.den = den;
    }

    public String numType() { return this.getClass().getTypeName(); }

    public String print() { return super.num + "/" + this.den; }

    public Integer square() { return super.num * super.num; }

}

interface NumberHelper<T> {
    public T square();
    public default String type() {
        return "I hold Num values.";
    }
}
