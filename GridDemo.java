import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GridDemo extends JFrame {
    public GridDemo() {
        setSize(600, 400);
        setLayout(new GridLayout(3, 3, 5, 10));
        Container c = getContentPane();
        
        Font f = new Font("Helvetica", Font.BOLD, 32);
        
        JLabel screen = new JLabel("Hello world!");
        c.add(BorderLayout.NORTH, screen);

        JPanel p = new JPanel();
        p.setBackground(Color.RED);
        c.add(BorderLayout.CENTER, p);

        for(int i = 1; i <= 9; i++) {
            JButton b = new JButton(i+"");
            b.addActionListener(new myListener());
            c.add(b);
        }
        setVisible(true);
    }

    public static void main(String args[]) {
        new GridDemo();
    }
}

class myListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.print("Yo");
    }
};
