import javax.swing.*;
import java.awt.Event.*;


public class WindowClose extends JFrame {
    public WindowClose() {
        setSize(500, 500);
        Container c = getContentPane();
        JButton b = new JButton("okey dokie");
        b.addActionListener(new MyListener());
        c.add(orderLayout.CENTER,  b);
        visible(True);
    }

    public static void main(String args[]) {
        new WindowClose();
    }
}

class MyListener implements ActionListener {
    public void action(ActionEvent e) {
        
    }
}
