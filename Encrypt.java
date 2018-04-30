/*
* Author: Me
* Try adding XOR ing with different chipping sequence.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

class Encrypt extends JFrame {

    public JTextArea plainText;
    
    public JTextArea cypherText;

    public JTextArea emojiText;

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

        Font font = new Font("Helvetica", Font.PLAIN, 24);
        Font emojiFont = new Font("EmojiOne Color", Font.PLAIN, 30);

        Container c = getContentPane();
        JPanel options = new JPanel();
        options.setLayout(new GridLayout(1, 5, 5, 10));
        
        shiftFactor = new JSpinner();
        JButton encrypt = new JButton("Encrypt");
        JButton indexed = new JButton("Index Shift");
        JButton emojiShift = new JButton("Emoji-Crypt™");
        JButton bruteForce = new JButton("Brute Force");
        
        encrypt.addActionListener(new myListener());
        indexed.addActionListener(new myListener());
        emojiShift.addActionListener(new myListener());
        bruteForce.addActionListener(new myListener());

        options.add(shiftFactor);
        options.add(encrypt);
        options.add(indexed);
        options.add(bruteForce);
        options.add(emojiShift);

        JPanel text = new JPanel();
        text.setLayout(new GridLayout(1, 3, 5, 10));

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
        cypherText.setForeground(Color.GREEN);
        cypherText.setBackground(Color.BLACK);
        cypherText.setCaretColor(Color.GREEN);
        cypherText.setFont(font);

        emojiText = new JTextArea(Emoji.baseString());
        emojiText.setLineWrap(true);
        emojiText.setWrapStyleWord(true);
        emojiText.setForeground(Color.WHITE);
        emojiText.setBackground(Color.DARK_GRAY);
        emojiText.setCaretColor(Color.WHITE);
        emojiText.setFont(font);

        text.add(plainText);
        text.add(cypherText);
        text.add(emojiText);

        JScrollPane scrollPane = new JScrollPane(text);

        c.add(options, BorderLayout.NORTH);
        c.add(scrollPane, BorderLayout.CENTER);
        setMinimumSize(new Dimension(400, 400));
        setVisible(true);
    }

    public static void main(String args[]) {
        new Encrypt();
    }

    public static boolean check_for_word(String word) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "/usr/share/dict/american-english"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(word) != -1) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
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
                case "Emoji-Crypt™":
                    String emoji = "";
                    Emoji temp1 = null;
                    temp = plainText.getText().toCharArray();
                    for(int i = 0; i < temp.length; i++) {
                        temp1 = new Emoji(temp[i], (int) shiftFactor.getValue());
                        emoji += temp1.toString();
                    }
                    emojiText.setText(emoji);
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
            boolean found = false;
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
                    // System.out.println("Is this your message? : " + temp.toString());
                }
                String guess = new String(temp);
                // Will work for individual words. Not spaces though.
                if(Encrypt.check_for_word(guess.toLowerCase())) {
                    // Found word in dictionary
                    cypherText.setText(guess.toLowerCase());
                    int reply = JOptionPane.showConfirmDialog(null, "Is " + guess.toLowerCase() + " your word?", "Guess", JOptionPane.YES_NO_OPTION);
                    if(reply == JOptionPane.YES_OPTION) {
                        guessVal = 100;
                        found = true;
                    } else {
                        guessVal++;
                    }
                } else {
                    cypherText.setText(new String(temp));
                    guessVal++;
                }
                try {
                    Thread.sleep(30);
                } catch(InterruptedException err) {
                    System.out.println(err);
                }
            }
            if(!found) {
                JOptionPane.showMessageDialog(null, "Could not parse out a word.");
            }
        }
    }

}

class Emoji {
    
    private static final byte[] base = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 };

    private static final char indexChar = ' ';

    private int shiftFactor;

    private byte[] val;

    Emoji(char c, int shiftFactor) {
        this.shiftFactor = shiftFactor;
        this.val = new byte[base.length];
        System.arraycopy(base, 0, this.val, 0, base.length);
        shift(getFactor(c));
    }

    public static String baseString() {
        return new String(base, Charset.forName("UTF-8"));
    }

    /*
    Be able to parse out unicode characters so they can be encrypted/decrpyted in the main windows with text.
    public static boolean isEmoji(char c) {
        String result = "\\u" + Integer.toHexString(c | 0x10000).substring(1);
        if result == unicode range {
            return true;
        } else {
            return false;
        }
    }
    */

    public String toString() {
        return new String(this.val, Charset.forName("UTF-8"));
    }

    private int getFactor(char c) {
        int result;
        if(((c - indexChar) + shiftFactor) > 62) {
            result = (c - indexChar) + shiftFactor - 63;
        } else if((c - indexChar) + shiftFactor < 0) {
            result = 63 - (c + indexChar);
        } else {
            result = (c - indexChar) + shiftFactor;
        }
        return result;
    }

    private void shift(int factor) {
        this.val[3] += factor;
    }

}
