import javax.swing.*;
import java.awt.*;

class gui {
    public static void main(String args[]) {
        // Create the Frame
        JFrame jframe = new JFrame("Budget App");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(700, 700);

        // Create two menubar buttons FILE and HELP
        JMenuBar menuBar = new JMenuBar();
        JMenu accountMenu = new JMenu("Acount");
        menuBar.add(accountMenu);

        // Create two more options in FILE button
        JMenuItem fileMenu1 = new JMenuItem("Sign up");
        JMenuItem fileMenu2 = new JMenuItem("Log in");
        accountMenu.add(fileMenu1);
        accountMenu.add(fileMenu2);

        // Text Area at the Center
        JTextArea textArea = new JTextArea();

        // Create the panel at bottom and add label, textArea and buttons
        JPanel panel = new JPanel(); // this panel is not visible in output
        JLabel label = new JLabel("Please Enter Text");
        JTextField textField = new JTextField(15); // accepts up to 15 characters
        JButton btn_send = new JButton("Send");
        JButton btn_reset = new JButton("Reset");

        panel.add(label); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(btn_send);
        panel.add(btn_reset);

        // Adding Components to the frame
        jframe.getContentPane().add(BorderLayout.SOUTH, panel);
        jframe.getContentPane().add(BorderLayout.NORTH, menuBar);
        jframe.getContentPane().add(BorderLayout.CENTER, textArea);

        // Action Listener
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
            }
        });

        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                textArea.setText("");
            }
        });

        jframe.setVisible(true);
    }
}
