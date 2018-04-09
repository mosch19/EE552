// Static items belong to the class rather than specific instances. Only one instance of a static field will exist no matter
// how many times the object is created. Static methods are not tied to a specific instance but can be referenced.
// Abstract classes are not allowed to have default methods unlike interfaces. Any body will throw an error. This is an advantage of interfaces.

abstract class Shape {
    double x, y;
    Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public abstract double area();
    public static void main(String args[]) {
        Rect r = new Rect(2.3, 4.5, 2.0, 3.0);
        Circle c = new Circle(3.4, 8.6, 9.3);
        System.out.println(r.show());
        System.out.println(c.show());
    }
}

class Rect extends Shape implements negatives<Double> {
    double width, height;
    Rect(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    public double area() {
        return width * height;
    }
    @Override
    public String show() {
        return "I am overriding my implementation.";
    }
    public Double abs() { return x; }
    public Double inverse() { return y; }
}

class Circle extends Shape implements negatives<Double> {
    double radius;
    Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }
    public double area() {
        return Math.PI*radius*radius;
    }
    public Double abs() {
        return radius;
    }
    public Double inverse() {
        return radius;
    }
}

interface negatives<T> {
    public T abs();
    public T inverse();
    public default String show() {
        return "I am a " + this.getClass().getName();
    }
}
