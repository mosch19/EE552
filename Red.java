import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Red extends JFrame {
    public Red() {
        setSize(600, 400);
        setLayout(new GridLayout(3, 3, 5, 10));
        Container c = getContentPane();
        c.setBackground(Color.BLACK);
        Font f = new Font("Helvetica", Font.BOLD, 32);
        JButton red = new JButton("Get Redder");
        c.add(BorderLayout.EAST, red);
        red.addActionListener(new MyListener());
        setVisible(true);
    }

    public static void main(String args[]) {
        new Red();
    }

    // This is weird and gives access
    class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color current = c.getBackground();
            int r = current.getRed() + 8;
            if (r > 255) {
                r = 0;
            }
            int g = current.getGreen();
            int b = current.getBlue();
            c.setBackground(Color(r, g, b));
        }
    }
}
