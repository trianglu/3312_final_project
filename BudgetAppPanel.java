import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetAppPanel extends JPanel {
    private JTextArea budgetAppTextArea;
    private JButton budgetAppBtn_create_account;
    private JButton budgetAppBtn_open_account;
    private JButton budgetAppBtn_reset;


    public BudgetAppPanel() {
        setLayout(new BorderLayout());

        // Create a budgetApp label
        JLabel budgetAppLabel = new JLabel("Home");
        add(budgetAppLabel, BorderLayout.NORTH);

        // Create a budgetApp text area
        budgetAppTextArea = new JTextArea();
        add(budgetAppTextArea, BorderLayout.CENTER);

        // Create a budgetApp panel at the bottom
        JPanel budgetAppBottomPanel = new JPanel();
        budgetAppBottomPanel.setLayout(new FlowLayout());

        budgetAppBtn_create_account = new JButton("Create Account");
        budgetAppBtn_open_account = new JButton("Open Account");
        budgetAppBtn_reset = new JButton("Reset");

        budgetAppBottomPanel.add(budgetAppBtn_create_account);
        budgetAppBottomPanel.add(budgetAppBtn_open_account);
        budgetAppBottomPanel.add(budgetAppBtn_reset);

        budgetAppBtn_open_account.setVisible(BudgetApp.getAccount() != null);

        add(budgetAppBottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        budgetAppBtn_create_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                budgetAppTextArea.append("Create Account\n");
                BudgetApp.createAccount();
                budgetAppTextArea.append("Please enter your details to create an account:\n");
                String firstName = JOptionPane.showInputDialog(null, "Enter First Name:");
                firstName = firstName == null ? " " : firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

                String lastName = JOptionPane.showInputDialog(null, "Enter Last Name:");
                lastName = lastName == null ? " " : lastName.substring(0,1).toUpperCase() + lastName.substring(1);

                String email = JOptionPane.showInputDialog(null, "Enter Email:");
                email = email == null ? " " : email.toLowerCase();
                
                Account account = BudgetApp.getAccount();
                account.setFirstName(firstName);
                account.setLastName(lastName);
                account.setEmail(email);
                
                budgetAppTextArea.append("Account details updated for: " + firstName + " " + lastName + "\n");
                budgetAppTextArea.append("Account created\n");
                budgetAppTextArea.append("Welcome " + firstName + " " + lastName + "\n");


                budgetAppBtn_open_account.setVisible(BudgetApp.getAccount() != null);
            }
        });

        budgetAppBtn_open_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new window for the account panel
                JFrame accountFrame = new JFrame("Account");
                accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                accountFrame.setSize(400, 300);
                accountFrame.setLayout(new BorderLayout());
                AccountPanel accountPanel = new AccountPanel();
                accountFrame.add(accountPanel, BorderLayout.CENTER);
                accountFrame.setVisible(true);
            }
        });
        
        budgetAppBtn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                budgetAppTextArea.setText("");
            }
        });
    }

    public JTextArea getBudgetAppTextArea() {
        return budgetAppTextArea;
    }

    public JButton getBudgetAppBtn_reset() {
        return budgetAppBtn_reset;
    }
}