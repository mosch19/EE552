import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame {
    Calculator() {
        setSize(600, 400);
        setLayout(gbl);

        GridBagConstraints c = new GridBagConstraints();


        setVisible(true);
    }

    public static void main(String args[]) {
        new Calculator();
    }
}

