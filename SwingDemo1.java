import javax.swing.*;
import java.awt.*;
import java.awt.Event;

class SwingDemo1 {
    public static void main(String args[]) {
        JFrame f = new JFrame();
        JButton j = new JButton("Ok");
        Container c = f.getContentPane();
        c.add(BorderLayout.NORTH, j);
        j.addActionListener(new myListener());
        f.setSize(1000, 700);
        f.setVisible(true);
    }
}

class myListener implements ActionListener {
    public static void actionPerformed(ActionEvent e) {
        
    }
};
