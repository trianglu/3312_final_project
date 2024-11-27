import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    protected BudgetAppPanel budgetAppPanel = new BudgetAppPanel();
    protected AccountPanel accountPanel = null;
    protected BudgetPanel budgetPanel = null;
    protected CategoryPanel categoryPanel = null;
    protected ExpensePanel expensePanel = null;
    protected JMenuBar menuBar = new JMenuBar();
    JMenu budgetAppMenu = new JMenu("Home");
    JMenu accountMenu = new JMenu("Account");
    JMenu budgetMenu = new JMenu("Budget");
    JMenu categoryMenu = new JMenu("Categories");
    JMenu expenseMenu = new JMenu("Expenses");

    
    // Constructor to set up the GUI
    public MainGUI() {
        setTitle("Budget App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a menu bar
        
        menuBar.add(budgetAppMenu);
        menuBar.add(accountMenu);
        menuBar.add(budgetMenu);
        menuBar.add(categoryMenu);
        menuBar.add(expenseMenu);

        accountMenu.setVisible(false);
        budgetMenu.setVisible(false);
        categoryMenu.setVisible(false);
        expenseMenu.setVisible(false);
        
        // Add menu bar to the frame
        add(menuBar, BorderLayout.NORTH);

        // Create a budgetApp panel
        budgetAppPanel = new BudgetAppPanel();

        //Add the budgetApp panel to the frame
        add(budgetAppPanel, BorderLayout.CENTER);

        //Set the frame visible
        setVisible(true);

        // Add action listeners to the menu items
        budgetAppMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the BudgetApp panel
                getContentPane().removeAll();
                add(budgetAppPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        accountMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // open the account panel and close any open panels
                if (accountPanel == null) {
                    accountPanel = new AccountPanel();
                }

                getContentPane().removeAll();
                add(accountPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        budgetMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // open the budget panel and close any open panels
                if(budgetPanel == null) {
                    budgetPanel = new BudgetPanel();
                }
                getContentPane().removeAll();
                add(budgetPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        categoryMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(categoryPanel == null) {
                    categoryPanel = new CategoryPanel();
                }
                // open the category panel and close any open panels
                getContentPane().removeAll();
                add(categoryPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        expenseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(expensePanel == null) {
                    expensePanel = new ExpensePanel();
                }
                // open the expense panel and close any open panels
                getContentPane().removeAll();
                add(expensePanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });


    }

    public class BudgetAppPanel extends JPanel implements Runnable {
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

                    // Set the account menu visible
                    accountMenu.setVisible(true);
                    budgetMenu.setVisible(false);
                    categoryMenu.setVisible(false);
                    expenseMenu.setVisible(false);

                    budgetAppBtn_open_account.setVisible(BudgetApp.getAccount() != null);
                }
            });

            budgetAppBtn_open_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    run();
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
        
        @Override
        public void run() {
            SwingUtilities.invokeLater(() -> {
                budgetAppTextArea.append("Open Account\n");
                budgetAppTextArea.append("Account opened\n");
                budgetAppTextArea.append("Welcome " + BudgetApp.getAccount().getFirstName() + " " + BudgetApp.getAccount().getLastName() + "\n");

                // Set the account panel visible
                budgetAppTextArea.setText(null);
                getContentPane().removeAll();
                if (accountPanel == null) {
                    accountPanel = new AccountPanel();
                }
                add(accountPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            });
        }
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
    
    public static void main(String[] args) {
        new MainGUI();
    }
}