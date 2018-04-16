/*
*   Java Bean: all members private, get/set methods, public no arg constructor, implements serializable
*   If undeclared all constructors call super();
*/

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Exam3 {
    public static void main(String args[]) {
        Pie banana = new Pie("Bannana", false, 12);
        banana.writeObject(new File("This.ser"));
        System.out.println(banana);
        
        Pie p = (Pie) Dessert.readObject(new File("This.ser"));
        System.out.println(p);
        System.out.println(p.sample());

        Cake c = new Cake("Vanilla", 3);
        c.writeObject(new File("Cake.ser"));
        System.out.println(c);

        Cake c2 = (Cake) Dessert.readObject(new File("Cake.ser"));
        System.out.println(c2);
        System.out.println(c.sample());

        Cookie c3 = new Cookie("Peanut butter", 6);
        System.out.println(c3);
    }
}

abstract class Dessert implements Serializable, What {
    
    private String flavor;
    
    public Dessert() {}

    Dessert(String flavor) {
        this.flavor = flavor;
    }

    public void setFlavor(String flavor) { this.flavor = flavor; }

    public String getFlavor() { return this.flavor; }

    public abstract String toString();

    /** 
     * Serialize the object
     * @param file Filename of the serialized object
     * @return void
    */
    public void writeObject(File file) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Deserialize object
     * @param file Filename of the serialized object
     * @return Dessert object
     */
    public static Dessert readObject(File file) {
        Dessert d = null;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            d = (Dessert) in.readObject();
        } catch(IOException e) {
            System.out.println(e);
        } catch(ClassNotFoundException c) {
            System.out.println(c);
        }
        return d;
    }

    @Override
    public boolean sample() {
        return false;
    }
    
    @Override
    public int getSomething() { return 1; }
}

class Pie extends Dessert {
    
    private boolean lattice;
    private double size;

    public Pie(String flavor, boolean lattice, double size) {
        super(flavor);
        this.lattice = lattice;
        this.size = size;
    }

    public Pie(String flavor, boolean lattice) {
        this(flavor, lattice, 0.0);
    }

    public Pie() {}

    public void setLattice(boolean lattice) { this.lattice = lattice; }

    public boolean getLattice() { return this.lattice; }

    public String toString() { return super.getFlavor() + " : " + this.size; }
}

class Cake extends Dessert {

    private int layers;

    Cake(String flavor, int layers) {
        super(flavor);
        this.layers = layers;
    }

    Cake(String flavor) {
        this(flavor, 0);
    }

    Cake() {}

    public String toString() { return super.getFlavor() + " with " + this.layers + " layers."; }
}

class Cookie extends Dessert {

    private int batchNum;

    Cookie(String flavor, int batchNum) {
        super(flavor);
        this.batchNum = batchNum;
    }

    Cookie(String flavor) {
        this(flavor, 0);
    }

    Cookie() {
        this("What");
    }

    @Override
    public String toString() {
        return super.getFlavor() + " with batch sizes of " + this.batchNum + ".";
    }
}

interface What {
    public default boolean sample() {
        return true;
    }
    public int getSomething();
}
