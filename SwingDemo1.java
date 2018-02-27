import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingDemo1 extends JFrame {

    public SwingDemo1(String title, Color bg, int w, int h) {
        this.setSize(w, h);
        this.setTitle(title);
        
        JButton j = new JButton("Ok");
        j.addActionListener(new myListener());

        JButton j2 = new JButton("What");
        j2.addActionListener(new myListener());

        Container c = this.getContentPane();
        c.add(BorderLayout.NORTH, j);
        c.add(BorderLayout.EAST, j2);
        c.setBackground(bg);

        this.setVisible(true);
    }


    public static void main(String args[]) {
        new SwingDemo1("Title", Color.BLUE, 800, 600);
        new SwingDemo1("Cool", Color.RED, 800, 600);
    }
}

class myListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.print("Yo");
    }
};
