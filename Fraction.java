class Fraction {
    private int num, den;

    public Fraction(int x, int y) {
        num = x;
        den = y;
    }

    // no const methods in Java...wtf
    public Fraction add(Fraction b) {
        int resultDen = 0;
        if (den != b.den) {
            resultDen = den * b.den;
        } else {
            resultDen = den;
        }
        return new Fraction(num + b.num, resultDen);
    }

    // the default print method for Java calls this
    public String toString() {
        return num + "/" + den;
    }

    public static void main(String args[]) {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = f2.add(f1);
        System.out.print(f3);
    }
}