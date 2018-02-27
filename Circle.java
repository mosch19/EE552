abstract class Shape {
    private int x, y;

    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public String getCoordinates() {
        return "(" + x + ", " + y + ")";
    }

    public String toString() {
        return "I am a " + getClass().getSimpleName() + " located at " + x + ", " + y;
    }

    public abstract double getArea();
}

class Rect extends Shape {
    private int x2, y2;

    Rect(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getWidth() { return 0; }

    public double getHeight() { return 0; }

    public String toString() {
        return super.toString() + " with x2 = " + x2 + " and y2 = " + y2 + ".";
    }

    @Override
    public double getArea() {
        return 1;
    }
}

class Circle extends Shape {

    private int r;

    Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    public String toString() {
        return super.toString() + " with radius = " + r + ".";
    }

    @Override
    public double getArea() {
        return Math.PI*r*r;
    }

    public static void main(String args[]) {
        Circle c = new Circle(100, 150, 40);
        System.out.println(c);
        System.out.println(c.getCoordinates());
        Rect r = new Rect(200, 244, 12, 4);
        System.out.println(r);
    }
}
