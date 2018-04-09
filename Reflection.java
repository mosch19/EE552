import java.lang.reflect.*;
import java.util.*;
// Every object in Java inherits from Object base class

class Reflection {
    public static void main(String args[]) {
        HashSet<String> attributesSet = new HashSet<>();
        HashSet<String> attributesGet = new HashSet<>();
        HashMap<String, String> hurray = new HashMap<>();

        Person b = new Person("What", "am I?", 90);
        Class c = b.getClass();
        Method[] m = c.getMethods();
        if (m == null) {
            System.exit(0);
        }
        for(Method x : m) {
            String n = x.getName();
            if(n.startsWith("get")) {
                attributesGet.add(n);
            } else if (n.startsWith("set")) {
                attributesSet.add(n);
            }
        }
    }
}
