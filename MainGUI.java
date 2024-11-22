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

    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();
    JMenu accountMenu = new JMenu("Account");
    menuBar.add(accountMenu);

    JMenuItem fileMenu1 = new JMenuItem("Sign up");
    JMenuItem fileMenu2 = new JMenuItem("Log in");
    accountMenu.add(fileMenu1);
    accountMenu.add(fileMenu2);

    // Add menu bar to the frame
    add(menuBar, BorderLayout.NORTH);

    // Create an instance of the AccountPanel class
    AccountPanel accountPanel = new AccountPanel();

    // Add the AccountPanel instance to the frame
    add(accountPanel, BorderLayout.CENTER);
    
    // Get the text area from the AccountPanel instance
    JTextArea accountTextArea = accountPanel.getAccountTextArea();

    // Get the reset button from the AccountPanel instance
    JButton accountBtn_reset = accountPanel.getAccountBtn_reset();

    accountBtn_reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            accountTextArea.setText("");
        }
    });

    // Set the frame visible
    setVisible(true);
    }

    public class AccountPanel extends JPanel {

        private JTextArea accountTextArea;
        private JButton accountBtn_send;
        private JButton accountBtn_reset;
    
        public AccountPanel() {
            setLayout(new BorderLayout());
    
            // Create an account label
            JLabel accountLabel = new JLabel("Account");
            add(accountLabel, BorderLayout.NORTH);
    
            // Create an account text area
            accountTextArea = new JTextArea();
            add(accountTextArea, BorderLayout.CENTER);
    
            // Create an account panel at the bottom
            JPanel accountBottomPanel = new JPanel();
            accountBottomPanel.setLayout(new FlowLayout());
    
            accountBtn_send = new JButton("Send");
            accountBtn_reset = new JButton("Reset");
    
            accountBottomPanel.add(accountBtn_send);
            accountBottomPanel.add(accountBtn_reset);
    
            add(accountBottomPanel, BorderLayout.SOUTH);
    
            // Add action listeners
            accountBtn_send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountTextArea.append("Account updated\n");
                }
            });
    
            accountBtn_reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountTextArea.setText("");
                }
            });
        }
    
        public JTextArea getAccountTextArea() {
            return accountTextArea;
        }
    
        public JButton getAccountBtn_send() {
            return accountBtn_send;
        }
    
        public JButton getAccountBtn_reset() {
            return accountBtn_reset;
        }
    }
    
    public static void main(String[] args) {
        new MainGUI();
    }
}