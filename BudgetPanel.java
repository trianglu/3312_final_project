import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetPanel extends JPanel {
    private JTextArea budgetTextArea;
    private JButton budgetBtn_send;
    private JButton budgetBtn_reset;

    public BudgetPanel() {
        setLayout(new BorderLayout());

        // Create a budget label
        JLabel budgetLabel = new JLabel("Budget");
        add(budgetLabel, BorderLayout.NORTH);

        // Create a budget text area
        budgetTextArea = new JTextArea();
        add(budgetTextArea, BorderLayout.CENTER);

        // Create a budget panel at the bottom
        JPanel budgetBottomPanel = new JPanel();
        budgetBottomPanel.setLayout(new FlowLayout());

        budgetBtn_send = new JButton("Send");
        budgetBtn_reset = new JButton("Reset");

        budgetBottomPanel.add(budgetBtn_send);
        budgetBottomPanel.add(budgetBtn_reset);

        add(budgetBottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        budgetBtn_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                budgetTextArea.append("Budget updated\n");
            }
        });

        budgetBtn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                budgetTextArea.setText("");
            }
        });
    }

    public JTextArea getBudgetTextArea() {
        return budgetTextArea;
    }

    public JButton getBudgetBtn_send() {
        return budgetBtn_send;
    }

    public JButton getBudgetBtn_reset() {
        return budgetBtn_reset;
    }
}

