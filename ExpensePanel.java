import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpensePanel extends JPanel {
    private JTextArea expenseTextArea;
    private JButton expenseBtn_send;
    private JButton expenseBtn_reset;

    public ExpensePanel() {
        setLayout(new BorderLayout());

        // Create an expense label
        JLabel expenseLabel = new JLabel("Expense");
        add(expenseLabel, BorderLayout.NORTH);

        // Create an expense text area
        expenseTextArea = new JTextArea();
        add(expenseTextArea, BorderLayout.CENTER);

        // Create an expense panel at the bottom
        JPanel expenseBottomPanel = new JPanel();
        expenseBottomPanel.setLayout(new FlowLayout());

        expenseBtn_send = new JButton("Send");
        expenseBtn_reset = new JButton("Reset");

        expenseBottomPanel.add(expenseBtn_send);
        expenseBottomPanel.add(expenseBtn_reset);

        add(expenseBottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        expenseBtn_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expenseTextArea.append("Expense updated\n");
            }
        }); 

        expenseBtn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expenseTextArea.setText("");
            }
        });
    }

    public JTextArea getExpenseTextArea() {
        return expenseTextArea;
    }

    public JButton getExpenseBtn_send() {
        return expenseBtn_send;
    }

    public JButton getExpenseBtn_reset() {
        return expenseBtn_reset;
    }
}
