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

        // // Create a menu bar
        // menuBar.add(budgetAppMenu);
        // menuBar.add(accountMenu);
        // menuBar.add(budgetMenu);
        // menuBar.add(categoryMenu);
        // menuBar.add(expenseMenu);

        // accountMenu.setVisible(false);
        // budgetMenu.setVisible(false);
        // categoryMenu.setVisible(false);
        // expenseMenu.setVisible(false);
        // // Add menu bar to the frame
        // add(menuBar, BorderLayout.NORTH);

        // Create a budgetApp panel
        budgetAppPanel = new BudgetAppPanel();

        add(budgetAppPanel, BorderLayout.CENTER);

        setVisible(true);

        // // Add action listeners to the menu items
        // budgetAppMenu.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // Open the BudgetApp panel
        //         getContentPane().removeAll();
        //         add(budgetAppPanel, BorderLayout.CENTER);
        //         revalidate();
        //         repaint();
        //     }
        // });

        // accountMenu.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         if (accountPanel == null) {
        //             accountPanel = new AccountPanel();
        //         }

        //         getContentPane().removeAll();
        //         add(accountPanel, BorderLayout.CENTER);
        //         revalidate();
        //         repaint();
        //     }
        // });
    }

    public class BudgetAppPanel extends JPanel {
        private JButton accountBtn;
        private JButton bankBtn;
        private JButton incomeBtn;
        private JButton notificationBtn;
        private JButton budgetBtn;
        private JButton expenseBtn;
        private JButton categoryBtn;
    
        public BudgetAppPanel() {
            setLayout(new BorderLayout());
    
            // Create a label for the budget app
            JLabel budgetAppLabel = new JLabel("Budget App");
            add(budgetAppLabel, BorderLayout.NORTH);
    
            // Create a panel for the buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(7, 1));
    
            // Create buttons for each panel
            accountBtn = new JButton("Account");
            bankBtn = new JButton("Bank");
            incomeBtn = new JButton("Income");
            notificationBtn = new JButton("Notification");
            budgetBtn = new JButton("Budget");
            expenseBtn = new JButton("Expense");
            categoryBtn = new JButton("Category");
    
            // Add action listeners to the buttons
            accountBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the account panel
                    AccountPanel accountPanel = new AccountPanel();
                    JFrame accountFrame = new JFrame("Account");
                    accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    accountFrame.add(accountPanel);
                    accountFrame.pack();
                    accountFrame.setVisible(true);
                }
            });
    
            bankBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the bank panel
                    BankPanel bankPanel = new BankPanel();
                    JFrame bankFrame = new JFrame("Bank");
                    bankFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    bankFrame.add(bankPanel);
                    bankFrame.pack();
                    bankFrame.setVisible(true);
                }
            });
    
            incomeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the income panel
                    IncomePanel incomePanel = new IncomePanel();
                    JFrame incomeFrame = new JFrame("Income");
                    incomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    incomeFrame.add(incomePanel);
                    incomeFrame.pack();
                    incomeFrame.setVisible(true);
                }
            });
    
            notificationBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the notification panel
                    NotificationPanel notificationPanel = new NotificationPanel();
                    JFrame notificationFrame = new JFrame("Notification");
                    notificationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    notificationFrame.add(notificationPanel);
                    notificationFrame.pack();
                    notificationFrame.setVisible(true);
                }
            });
    
            budgetBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the budget panel
                    BudgetPanel budgetPanel = new BudgetPanel();
                    JFrame budgetFrame = new JFrame("Budget");
                    budgetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    budgetFrame.add(budgetPanel);
                    budgetFrame.pack();
                    budgetFrame.setVisible(true);
                }
            });
    
            expenseBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the expense panel
                    ExpensePanel expensePanel = new ExpensePanel();
                    JFrame expenseFrame = new JFrame("Expense");
                    expenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    expenseFrame.add(expensePanel);
                    expenseFrame.pack();
                    expenseFrame.setVisible(true);
                }
            });
    
            categoryBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the category panel
                    CategoryPanel categoryPanel = new CategoryPanel();
                    JFrame categoryFrame = new JFrame("Category");
                    categoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    categoryFrame.add(categoryPanel);
                    categoryFrame.pack();
                    categoryFrame.setVisible(true);
                }
            });
    
            // Add the buttons to the button panel
            buttonPanel.add(accountBtn);
            buttonPanel.add(bankBtn);
            buttonPanel.add(incomeBtn);
            buttonPanel.add(notificationBtn);
            buttonPanel.add(budgetBtn);
            buttonPanel.add(expenseBtn);
            buttonPanel.add(categoryBtn);
    
            // Add the button panel to the budget app panel
            add(buttonPanel, BorderLayout.CENTER);
        }
    }  
    public class AccountPanel extends JPanel {
        private JTextArea accountTextArea;
        private JButton accountBtn_view_transactions;
        private JButton accountBtn_view_budgets;
        private JButton accountBtn_view_income;
        private JButton accountBtn_view_notifications;
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

            accountBtn_view_transactions = new JButton("View Transactions");
            accountBtn_view_budgets = new JButton("View Budgets");
            accountBtn_view_income = new JButton("View Income");
            accountBtn_view_notifications = new JButton("View Notifications");
            accountBottomPanel.add(accountBtn_view_transactions);
            accountBottomPanel.add(accountBtn_view_budgets);
            accountBottomPanel.add(accountBtn_view_income);
            accountBottomPanel.add(accountBtn_view_notifications);
            add(accountBottomPanel, BorderLayout.SOUTH);
            // Add action listeners
            accountBtn_view_transactions.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View transactions logic here
                }
            });
            accountBtn_view_budgets.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View budgets logic here
                }
            });
            accountBtn_view_income.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View income logic here
                }
            });
            accountBtn_view_notifications.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View notifications logic here
                }
            });
        }
    }
    public class BankPanel extends JPanel {
        private JTextArea bankTextArea;
        private JButton bankBtn_create_account;
        private JButton bankBtn_delete_account;
        private JButton bankBtn_update_balance;
        private JButton bankBtn_view_transaction_history;
        public BankPanel() {
            setLayout(new BorderLayout());
            // Create a bank label
            JLabel bankLabel = new JLabel("Bank");
            add(bankLabel, BorderLayout.NORTH);
            // Create a bank text area
            bankTextArea = new JTextArea();
            add(bankTextArea, BorderLayout.CENTER);
            // Create a bank panel at the bottom
            JPanel bankBottomPanel = new JPanel();
            bankBottomPanel.setLayout(new FlowLayout());

            bankBtn_create_account = new JButton("Create Account");
            bankBtn_delete_account = new JButton("Delete Account");
            bankBtn_update_balance = new JButton("Update Balance");
            bankBtn_view_transaction_history = new JButton("View Transaction History");
            bankBottomPanel.add(bankBtn_create_account);
            bankBottomPanel.add(bankBtn_delete_account);
            bankBottomPanel.add(bankBtn_update_balance);
            bankBottomPanel.add(bankBtn_view_transaction_history);
            add(bankBottomPanel, BorderLayout.SOUTH);
            // Add action listeners
            bankBtn_create_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Create account logic here
                }
            });
            bankBtn_delete_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Delete account logic here
                }
            });
            bankBtn_update_balance.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update balance logic here
                }
            });
            bankBtn_view_transaction_history.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View transaction history logic here
                }
            });
        }
    }
    public class IncomePanel extends JPanel {
        private JTextArea incomeTextArea;
        private JButton incomeBtn_view_income_streams;
        private JButton incomeBtn_add_income_stream;
        public IncomePanel() {
            setLayout(new BorderLayout());
            // Create an income label
            JLabel incomeLabel = new JLabel("Income");
            add(incomeLabel, BorderLayout.NORTH);
            // Create an income text area
            incomeTextArea = new JTextArea();
            add(incomeTextArea, BorderLayout.CENTER);
            // Create an income panel at the bottom
            JPanel incomeBottomPanel = new JPanel();
            incomeBottomPanel.setLayout(new FlowLayout());
            incomeBtn_view_income_streams = new JButton("View Income Streams");
            incomeBtn_add_income_stream = new JButton("Add Income Stream");

            incomeBottomPanel.add(incomeBtn_view_income_streams);
            incomeBottomPanel.add(incomeBtn_add_income_stream);
            add(incomeBottomPanel, BorderLayout.SOUTH);
            // Add action listeners
            incomeBtn_view_income_streams.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View income streams logic here
                }
            });
            incomeBtn_add_income_stream.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add income stream logic here
                }
            });
        }
    }

    public class NotificationPanel extends JPanel {
    private JTextArea notificationTextArea;
    private JButton notificationBtn_view_notifications;

    public NotificationPanel() {
            setLayout(new BorderLayout());
    
            // Create a notification label
            JLabel notificationLabel = new JLabel("Notifications");
            add(notificationLabel, BorderLayout.NORTH);
    
            // Create a notification text area
            notificationTextArea = new JTextArea();
            add(notificationTextArea, BorderLayout.CENTER);
    
            // Create a notification panel at the bottom
            JPanel notificationBottomPanel = new JPanel();
            notificationBottomPanel.setLayout(new FlowLayout());
    
            notificationBtn_view_notifications = new JButton("View Notifications");
    
            notificationBottomPanel.add(notificationBtn_view_notifications);
    
            add(notificationBottomPanel, BorderLayout.SOUTH);
    
            // Add action listener
            notificationBtn_view_notifications.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View notifications logic here
                }
            });
        }
    }

    public class BudgetPanel extends JPanel {
        private JTextArea budgetTextArea;
        private JButton budgetBtn_view_budgets;
        private JButton budgetBtn_view_expenses;
        private JButton budgetBtn_view_categories;
    
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
    
            budgetBtn_view_budgets = new JButton("View Budgets");
            budgetBtn_view_expenses = new JButton("View Expenses");
            budgetBtn_view_categories = new JButton("View Categories");
    
            budgetBottomPanel.add(budgetBtn_view_budgets);
            budgetBottomPanel.add(budgetBtn_view_expenses);
            budgetBottomPanel.add(budgetBtn_view_categories);

    
            add(budgetBottomPanel, BorderLayout.SOUTH);
    
            // Add action listeners
            budgetBtn_view_budgets.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View budgets logic here
                }
            });
    
            budgetBtn_view_expenses.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View expenses logic here
                }
            });
    
            budgetBtn_view_categories.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View categories logic here
                }
            });
        }
    }
    
    public class ExpensePanel extends JPanel {
        private JTextArea expenseTextArea;
        private JButton expenseBtn_view_expenses;
        private JButton expenseBtn_add_expense;
    
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
    
            expenseBtn_view_expenses = new JButton("View Expenses");
            expenseBtn_add_expense = new JButton("Add Expense");
    
            expenseBottomPanel.add(expenseBtn_view_expenses);
            expenseBottomPanel.add(expenseBtn_add_expense);
    
            add(expenseBottomPanel, BorderLayout.SOUTH);
    
            // Add action listeners
            expenseBtn_view_expenses.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View expenses logic here
                }
            });
    
            expenseBtn_add_expense.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add expense logic here
                }
                });
                    }
                }
    
    public class CategoryPanel extends JPanel {
        private JTextArea categoryTextArea;
        private JButton categoryBtn_view_categories;
        private JButton categoryBtn_add_category;
    
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
    
            categoryBtn_view_categories = new JButton("View Categories");
            categoryBtn_add_category = new JButton("Add Category");
    
            categoryBottomPanel.add(categoryBtn_view_categories);
            categoryBottomPanel.add(categoryBtn_add_category);
    
            add(categoryBottomPanel, BorderLayout.SOUTH);
    
            // Add action listeners
            categoryBtn_view_categories.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View categories logic here
                }
            });
    
            categoryBtn_add_category.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add category logic here
                }
            });
        }
    }
    public static void main(String[] args) {
        new MainGUI();
    }
}

