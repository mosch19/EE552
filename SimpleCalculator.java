import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SimpleCalculator extends JFrame {
    private JLabel screen;
    public SimpleCalculator() {
        setSize(600, 400);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        Container c = getContentPane();
        
        Font f = new Font("Helvetica", Font.BOLD, 32);
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(5, 4, 5, 10));

        String[] buttonNames = { 
            "C", "%", "^", "C",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            ".", "0", "=", "+"
        };

        for(String x : buttonNames) {
            JButton b = new JButton(x);
            b.addActionListener(new myListener());
            buttons.add(b);
        }

        screen = new JLabel("0", SwingConstants.RIGHT);
        screen.setFont(new Font("Helvetica", Font.PLAIN, 36));
        c.add(screen, BorderLayout.NORTH);

        c.add(buttons, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String args[]) {
        new SimpleCalculator();
    }

    class myListener implements ActionListener {
        private int numberInputs = 0;
        public void actionPerformed(ActionEvent e) {
            numberInputs++;
            if(numberInputs == 3) {
                numberInputs = 0;
            }
            if(screen.getText() == "Error!" || screen.getText() == "Enter an operation...") {
                screen.setText("0");
            }
            if(e.getActionCommand() == "=") {
                String line = screen.getText();
                System.out.println(line);
                try {
                    String[] splitted = line.split("\\s+");
                    double firstNum = Double.parseDouble(splitted[0]);
                    String op = splitted[1];
                    double lastNum = Double.parseDouble(splitted[2]);
                    double result = 0;

                    switch(op) {
                        case "+":
                            System.out.println("Addition");
                            result = firstNum + lastNum;
                            screen.setText(result + "");
                            break;
                        case "-":
                            System.out.println("Subtraction");
                            result = firstNum - lastNum;
                            screen.setText(result + "");
                            break;
                        case "*":
                            System.out.println("Multiplication");
                            result = firstNum * lastNum;
                            screen.setText(result + "");
                            break;
                        case "/":
                            System.out.println("Division");
                            result = firstNum / lastNum;
                            screen.setText(result + "");
                            break;
                        case "^":
                            System.out.println("Exponent");
                            result = Math.pow(firstNum, lastNum);
                            screen.setText(result + "");
                            break;
                        case "%":
                            System.out.println("Modulus");
                            result = firstNum % lastNum;
                            screen.setText(result + "");
                            break;
                        default:
                            screen.setText("Enter an operation...");
                            break;
                    }
                } catch(NumberFormatException n) {
                    System.out.println(n);
                    screen.setText("Error!");
                }
            } else if(e.getActionCommand() == "C") {
                screen.setText("0");
            } else if(screen.getText() == "0") {
                screen.setText(e.getActionCommand());    
            } else if(!isNumber(e.getActionCommand())) {
                // I know its not a number so add a space
                System.out.println("number entered");
                screen.setText(screen.getText() + " " + e.getActionCommand() + " ");
            } else {
                screen.setText(screen.getText() + "" + e.getActionCommand());
            }
            System.out.println(e.getActionCommand());
        }
    }

    public boolean isNumber(String x) {
        try {
            double result = Double.parseDouble(x);
        } catch(NumberFormatException n) {
            return false;
        }
        return true;
    }

}
