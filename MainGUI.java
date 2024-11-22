import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    // Constructor to set up the GUI
    public MainGUI() {
        setTitle("Budget App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Components (Buttons, Panels, etc.)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        panel.add(button1);
        panel.add(button2);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);

        // Add Action Listeners
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 1 click
                JOptionPane.showMessageDialog(null, "Button 1 Clicked");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle button 2 click
                JOptionPane.showMessageDialog(null, "Button 2 Clicked");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });
    }
}