import java.io.FileReader;
import java.util.Scanner;

class OpenFile {
    public static void main(String args[]) {
        FileReader fr = new FileReader("test.dat");
        Scanner e = new Scanner(fr);
        String text = e.next();
        e.close();
    }
}