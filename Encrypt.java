/*
* Author: Me
* Try adding XOR ing with different chipping sequence.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

class Encrypt extends JFrame {

    public JTextArea plainText;
    
    public JTextArea cypherText;

    private JSpinner shiftFactor;

    Encrypt() {
        setSize(700, 500);
        setTitle("Caesar Shift");
        
        // Exit the program
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        Font font = new Font("Helvetica", Font.PLAIN, 16);

        Container c = getContentPane();
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(1, 5, 5, 10));
        
        shiftFactor = new JSpinner();
        JButton encrypt = new JButton("Encrypt");
        JButton indexed = new JButton("Index Shift");
        JButton bruteForce = new JButton("Brute Force");
        encrypt.addActionListener(new myListener());
        indexed.addActionListener(new myListener());
        bruteForce.addActionListener(new myListener());

        options.add(shiftFactor);
        options.add(encrypt);
        options.add(indexed);
        options.add(bruteForce);

        JPanel text = new JPanel();
        text.setLayout(new GridLayout(1, 2, 5, 10));

        plainText = new JTextArea("Plain text...");
        plainText.setLineWrap(true);
        plainText.setWrapStyleWord(true);
        plainText.setForeground(Color.WHITE);
        plainText.setBackground(Color.DARK_GRAY);
        plainText.setCaretColor(Color.WHITE);
        plainText.setFont(font);

        cypherText = new JTextArea("Cypher text...");
        cypherText.setLineWrap(true);
        cypherText.setWrapStyleWord(true);
        cypherText.setForeground(Color.DARK_GRAY);
        cypherText.setBackground(Color.WHITE);
        cypherText.setCaretColor(Color.DARK_GRAY);
        cypherText.setFont(font);

        text.add(plainText);
        text.add(cypherText);

        c.add(options, BorderLayout.NORTH);
        c.add(text, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String args[]) {
        new Encrypt();
    }

    class myListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            char[] temp;
            switch(e.getActionCommand()) {
                case "Encrypt":
                    temp = plainText.getText().toCharArray();
                    for(int i = 0; i < temp.length; i++) {
                        temp[i] += (int) shiftFactor.getValue();
                    }
                    cypherText.setText(new String(temp));
                    break;
                case "Index Shift":
                    temp = plainText.getText().toCharArray();
                    for(int i = 0; i < temp.length; i++) {
                        temp[i] += i;
                    }
                    cypherText.setText(new String(temp));
                    break;
                case "Brute Force":
                    BruteThread bruteThread = new BruteThread(cypherText.getText().toCharArray());
                    bruteThread.start();
                    break;
                default:
                    System.out.println("What");
            }
        }
    }

    class BruteThread extends Thread {
        private char[] original;
        private char[] temp;
        private int guessVal;
        private boolean ascii;
    
        BruteThread(char[] original) {
            this.original = original;
            this.temp = original;
            this.guessVal = -99;
            this.ascii = false;
        }
    
        public void run() {
            while(guessVal < 100) {
                ascii = false;
                temp = original.clone();
                for(int i = 0; i < temp.length; i++) {
                    temp[i] += guessVal;
                    if(temp[i] > 0 && temp[i] < 128) {
                        ascii = true;
                    }
                }
                if(ascii) {
                    System.out.println("Is this your message? : " + temp.toString());
                }
                cypherText.setText(new String(temp));
                guessVal++;
                try {
                    Thread.sleep(250);
                } catch(InterruptedException err) {
                    System.out.println(err);
                }
            }
        }
    }

}
