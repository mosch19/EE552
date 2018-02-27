class Vector {

    private int x, y, z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector add(Vector b) {
        return new Vector(x + b.x, y + b.y, z + b.z);
    }

    public Vector subtract(Vector b) {
        return new Vector(x - b.x, y - b.y, z - b.z);
    }

    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }

    static double dot(Vector a, Vector b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public static void main(String args[]) {
        Vector a = new Vector(9, 2, 3);
        Vector b = new Vector();            // Make a vector with all zero values

        System.out.println(a);
        System.out.println(b);

        Vector c = new Vector(4, 2, 9);
        Vector d = a.add(c);
        Vector e = a.subtract(c);

        System.out.println(d);
        System.out.println(e);

        Double val = dot(d, e);
        System.out.println("Dot product is " + val);
    }
}
