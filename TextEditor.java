/*
    Author: Michael Moschetti
    References: https://stackoverflow.com/questions/33785004/default-text-in-jtextarea
    https://stackoverflow.com/questions/2824631/how-to-change-the-cursor-blink-color
    https://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java
    https://alvinalexander.com/java/java-jtextarea-cursor-caret-position-location
    https://stackoverflow.com/questions/2088016/add-a-new-line-to-the-end-of-a-jtextarea
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class TextEditor extends JFrame {

    private JTextArea fileContents;

    private JTextField fileName;

    private JComboBox<String> fileOpts;

    // Hold the text from the cut/copy operations
    private String heldText;
    
    public TextEditor() {
        setSize(700, 500);
        setTitle("Text Editor");
        // Exit the program
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        Container c = getContentPane();

        // Add the Save, Load, Copy, Cut, Paste buttons
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1, 5, 5, 10));
        String[] menuButtons = { "Save", "Load", "Copy", "Cut", "Paste" };
        for (String x : menuButtons) {
            JButton b = new JButton(x);
            b.addActionListener(new myListener());
            menu.add(b);
        }
        menu.setBackground(Color.DARK_GRAY);
        c.add(menu, BorderLayout.NORTH);

        // Add the file name text entry
        JPanel fileInfo = new JPanel();
        fileInfo.setLayout(new GridLayout(1, 3, 20, 10));

        // Label explaining options
        JLabel help = new JLabel("Enter file name & type:", SwingConstants.LEFT);
        fileInfo.add(help);

        // Filename entry
        fileName = new JTextField("Enter filename...");
        fileInfo.add(fileName);

        // File type options
        String[] fileTypes = { ".txt", ".csv", ".dat" };
        fileOpts = new JComboBox<>(fileTypes);
        fileInfo.add(fileOpts);
        c.add(fileInfo, BorderLayout.SOUTH);

        // Add the window for writing main text
        Font font = new Font("Helvetica", Font.PLAIN, 14);
        fileContents = new JTextArea("Enter text here...");
        fileContents.setForeground(Color.WHITE);
        fileContents.setBackground(Color.DARK_GRAY);
        fileContents.setCaretColor(Color.WHITE);
        fileContents.setFont(font);
        c.add(fileContents, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String args[]) {
        new TextEditor();
    }

    class myListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String currentText;
            switch(e.getActionCommand()) {
                case "Save":
                    try {
                        String ext = String.valueOf(fileOpts.getSelectedItem());
                        File file = new File(fileName.getText() + ext);
                        BufferedWriter output = new BufferedWriter(new FileWriter(file));
                        output.write(fileContents.getText());
                        output.close();
                    } catch(IOException err) {
                        System.out.println(err);
                    }
                    break;
                case "Load":
                    try {
                        String ext = String.valueOf(fileOpts.getSelectedItem());
                        File file = new File(fileName.getText() + ext);
                        BufferedReader input = new BufferedReader(new FileReader(file));
                        String line;
                        boolean firstLine = true;
                        while((line = input.readLine()) != null) {
                            // If first line set the text else append
                            if(firstLine) {
                                firstLine = false;
                                fileContents.setText(line + "\n");
                            } else {
                                fileContents.append(line + "\n");
                            }
                        }
                        input.close();
                    } catch(IOException load) {
                        System.out.println(load);
                    }
                    break;
                case "Copy":
                    heldText = fileContents.getSelectedText();
                    System.out.println(heldText);
                    break;
                case "Cut":
                    currentText = fileContents.getText();
                    heldText = fileContents.getSelectedText();
                    fileContents.setText(currentText.replace(heldText, ""));
                    break;
                case "Paste":
                    // Get index of caret
                    int caretPosition = fileContents.getCaretPosition();
                    currentText = fileContents.getText();

                    String beforeIndex = currentText.substring(0, caretPosition);
                    String afterIndex = currentText.substring(caretPosition);

                    // Insert held text at position
                    String newText = beforeIndex + heldText + afterIndex;
                    fileContents.setText(newText);
                    break;
                default:
                    break;
            }
        }
    }

}
