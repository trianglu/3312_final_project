import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

