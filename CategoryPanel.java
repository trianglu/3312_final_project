import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

    public class CategoryPanel extends JPanel {
        private JTextArea categoryTextArea;
        private JButton categoryBtn_send;
        private JButton categoryBtn_reset;

        public CategoryPanel() {
            setLayout(new BorderLayout());   

            // Create a category label
            JLabel categoryLabel = new JLabel("Category");
            add(categoryLabel, BorderLayout.NORTH);

            // Create a category text area
            categoryTextArea = new JTextArea();
            add(categoryTextArea, BorderLayout.CENTER);

            // Create a category panel at the bottom
            JPanel categoryBottomPanel = new JPanel();
            categoryBottomPanel.setLayout(new FlowLayout());    

            categoryBtn_send = new JButton("Send");
            categoryBtn_reset = new JButton("Reset");

            categoryBottomPanel.add(categoryBtn_send);
            categoryBottomPanel.add(categoryBtn_reset);

            add(categoryBottomPanel, BorderLayout.SOUTH);

            // Add action listeners
            categoryBtn_send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    categoryTextArea.append("Category updated\n");
                }
            });

            categoryBtn_reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    categoryTextArea.setText("");
                }
            });
        }

        public JTextArea getCategoryTextArea() {
            return categoryTextArea;
        }

        public JButton getCategoryBtn_send() {
            return categoryBtn_send;
        }

        public JButton getCategoryBtn_reset() {
            return categoryBtn_reset;
        }
    
    
}