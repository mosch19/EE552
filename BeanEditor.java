import javax.swing.*;
import java.awt.*;
import java.awt.Event;
import java.util.*;
import java.lang.reflect.*;

class BeanEditor extends JFrame {

    private String[] getAttributeList(Object edit) {
        Class c = edit.getClass();
        Method[] m = c.getMethods();
        HashSet<String> setters = new HashSet<>();
        HashSet<String> getters = new HashSet<>();
        for (Method x : m) {
            String name = x.getName();
            if(name.startsWith("get")) {
                getters.add(name);
            } else if(name.startsWith("set")) {
                setters.add(name);
            }
        }
        ArrayList<String> attributes = new ArrayList<>();
        for (String temp : getters) {
            System.out.println(temp);
            // TODO strip off the get or set...
            if(setters.contains(temp)) {
                attributes.add(temp);
                System.out.println(temp);
            }
        }
        return attributes.toArray(new String[attributes.size()]);
    }

    BeanEditor(Object edit) {
        super("Bean Editor");
        String[] attributes = getAttributeList(edit);
        System.out.println(attributes.length);
        for(int i = 0; i < attributes.length; i++) {
            System.out.println(attributes[i]);
        }
        setSize(800, 700);
        Container c = getContentPane();
        // Return array of String with attributes
        String[] attributesS = getAttributeList(edit);
        for(int i = 0; i < attributes.length; i++) {
            System.out.println(attributes[i]);
        }
        c.setLayout(new GridLayout(attributes.length, 2));
        for (int i = 0; i < attributes.length; i++) {
            c.add(new JLabel(attributes[i]));
            c.add(new JTextField());
        }
        setVisible(true);
    }

    public static void main(String args[]) {
        Person p = new Person();
        new BeanEditor(p);
        System.out.println(p);
    }
}
