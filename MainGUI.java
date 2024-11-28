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

        budgetAppMenu.setVisible(true);
        accountMenu.setVisible(false);
        budgetMenu.setVisible(false);
        categoryMenu.setVisible(false);
        expenseMenu.setVisible(false);

        add(menuBar, BorderLayout.NORTH);

        // Create a budgetApp panel
        budgetAppPanel = new BudgetAppPanel();

        add(budgetAppPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public class BudgetAppPanel extends JPanel {
        private JTextArea budgetAppTextArea;
        private JButton budgetAppBtn_create_account;
        private JButton budgetAppBtn_open_account;
    
        public BudgetAppPanel() {
            setLayout(new BorderLayout());
    
            // Create a label for the budget app
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
    
            budgetAppBottomPanel.add(budgetAppBtn_create_account);
            budgetAppBottomPanel.add(budgetAppBtn_open_account);

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
                    lastName = lastName == null ? " " : lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                    String email = JOptionPane.showInputDialog(null, "Enter Email:");
                    BudgetApp.getAccount().setFirstName(firstName);
                    BudgetApp.getAccount().setLastName(lastName);
                    BudgetApp.getAccount().setEmail(email);
                    budgetAppTextArea.append("Account created successfully\n");
                    budgetAppBtn_open_account.setVisible(true);

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
                    JFrame accountFrame = new JFrame("Account");
                    accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    accountFrame.setSize(800, 600);
                    accountFrame.setLayout(new BorderLayout());
                    AccountPanel accountPanel = new AccountPanel();
                    accountFrame.add(accountPanel, BorderLayout.CENTER);
                    accountFrame.setVisible(true);
                }
            });
        }
    }  
    public class AccountPanel extends JPanel {
        private JTextArea accountTextArea;
        private JButton accountBtn_view_categories;
        private JButton accountBtn_add_income;
        private JButton accountBtn_view_notifications;
        private JButton accountBtn_link_bank_account;

        public AccountPanel() {
            setLayout(new BorderLayout());
            // Create an account label
            JLabel accountLabel = new JLabel("Account");
            add(accountLabel, BorderLayout.NORTH);

            // Create an account text area
            accountTextArea = new JTextArea();
            add(accountTextArea, BorderLayout.CENTER);

            accountTextArea.append("Welcome to your account, " + BudgetApp.getAccount().getFirstName() + " " + BudgetApp.getAccount().getLastName() + "\n");

            // Create an account panel at the bottom
            JPanel accountBottomPanel = new JPanel();
            accountBottomPanel.setLayout(new FlowLayout());

            accountBtn_view_categories = new JButton("View Categories");
            accountBtn_add_income = new JButton("Add Income");
            accountBtn_view_notifications = new JButton("View Notifications");
            accountBtn_link_bank_account = new JButton("Link Bank Account");
            accountBottomPanel.add(accountBtn_view_categories);
            accountBottomPanel.add(accountBtn_add_income);
            accountBottomPanel.add(accountBtn_view_notifications);
            accountBottomPanel.add(accountBtn_link_bank_account);
            add(accountBottomPanel, BorderLayout.SOUTH);
            // Add action listeners
            
            accountBtn_view_categories.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View categories logic here
                    JFrame categoryFrame = new JFrame("Categories");
                    categoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    categoryFrame.setSize(800, 600);
                    categoryFrame.setLayout(new BorderLayout());
                    CategoryPanel categoryPanel = new CategoryPanel();
                    categoryFrame.add(categoryPanel, BorderLayout.CENTER);
                    categoryFrame.setVisible(true);
                }
            });
            accountBtn_add_income.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View income logic here
                    String incomeID = JOptionPane.showInputDialog(null, "Enter income ID:");
                    String incomeAmount = JOptionPane.showInputDialog(null, "Enter income amount:");
                    String incomeFrequency = JOptionPane.showInputDialog(null, "Enter income frequency:");
                    
                    Income income = new Income(Integer.parseInt(incomeID), Double.parseDouble(incomeAmount), Double.parseDouble(incomeFrequency));
                    BudgetApp.getAccount().addIncome(income);
                    accountTextArea.append("Income added successfully\n");
                }
            });
            accountBtn_view_notifications.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View notifications logic here
                    JFrame notificationFrame = new JFrame("Notifications");
                    notificationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    notificationFrame.setSize(800, 600);
                    notificationFrame.setLayout(new BorderLayout());
                    NotificationPanel notificationPanel = new NotificationPanel();
                    notificationFrame.add(notificationPanel, BorderLayout.CENTER);
                    notificationFrame.setVisible(true);
                }
            });
            accountBtn_link_bank_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Link bank account logic here
                    JFrame bankFrame = new JFrame("Bank");
                    bankFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    bankFrame.setSize(800, 600);
                    bankFrame.setLayout(new BorderLayout());
                    BankPanel bankPanel = new BankPanel();
                    bankFrame.add(bankPanel, BorderLayout.CENTER);
                    bankFrame.setVisible(true);
                }
            });
        }
    }
    public class BankPanel extends JPanel {
        private JTextArea bankTextArea;
        private JButton bankBtn_connect_account;
        private JButton bankBtn_update_account;
        private JButton bankBtn_update_balance;
        private JButton bankBtn_view_transaction_history;
        private JButton bankBtn_back_to_account;
        private Bank bank;
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

            bankBtn_connect_account = new JButton("Link Account");
            bankBtn_update_account = new JButton("Update Account");
            bankBtn_update_balance = new JButton("Update Balance");
            bankBtn_view_transaction_history = new JButton("View Transaction History");
            bankBtn_back_to_account = new JButton("Back to Account");
            bankBottomPanel.add(bankBtn_connect_account);
            bankBottomPanel.add(bankBtn_update_account);
            bankBottomPanel.add(bankBtn_update_balance);
            bankBottomPanel.add(bankBtn_view_transaction_history);
            bankBottomPanel.add(bankBtn_back_to_account);
            add(bankBottomPanel, BorderLayout.SOUTH);
            // Add action listeners
            bankBtn_connect_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Create account logic here
                    String bankIDInput = JOptionPane.showInputDialog(null, "Enter Bank ID:");
                    int bankID = Integer.parseInt(bankIDInput);

                    String bankName = JOptionPane.showInputDialog(null, "Enter Bank Name:");

                    String accountNumberInput = JOptionPane.showInputDialog(null, "Enter Account Number:");
                    int accountNumber = Integer.parseInt(accountNumberInput);

                    String initialBalanceInput = JOptionPane.showInputDialog(null, "Enter Initial Balance:");
                    double initialBalance = Double.parseDouble(initialBalanceInput);

                    bank = new Bank(bankID, bankName, accountNumber, initialBalance);
                    bankTextArea.append("Account created with Bank ID: " + bankID + ", Bank Name: " + bankName + ", Account Number: " + accountNumber + ", Initial Balance: " + initialBalance + "\n");
                }
            });
            bankBtn_update_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // update account logic here
                    String bankIDInput = JOptionPane.showInputDialog(null, "Enter new Bank ID:");
                    int bankID = Integer.parseInt(bankIDInput);

                    String bankName = JOptionPane.showInputDialog(null, "Enter new Bank Name:");

                    String accountNumberInput = JOptionPane.showInputDialog(null, "Enter new Account Number:");
                    int accountNumber = Integer.parseInt(accountNumberInput);

                    bank.setBankID(bankID);
                    bank.setBankName(bankName);
                    bank.setAccountNumber(accountNumber);
                    bankTextArea.append("Account updated with Bank ID: " + bankID + ", Bank Name: " + bankName + "\n");
                }
            });
            bankBtn_update_balance.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update balance logic here
                    String balanceInput = JOptionPane.showInputDialog(null, "Enter new Balance:");
                    double balance = Double.parseDouble(balanceInput);
                    bank.updateBalance(balance);
                    bankTextArea.append("Balance updated to: " + bank.getBalance() + "\n");
                }
            });
            bankBtn_view_transaction_history.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View transaction history logic here
                    bankTextArea.append("Transaction History:\n");
                    for (Double transaction : bank.getTransactions()) {
                        bankTextArea.append(transaction.toString() + "\n");
                    }
                }
            });

            bankBtn_back_to_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame accountFrame = new JFrame("Account");
                    accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    accountFrame.setSize(800, 600);
                    accountFrame.setLayout(new BorderLayout());

                    // Create a new AccountPanel instance
                    AccountPanel accountPanel = new AccountPanel();
                    accountFrame.add(accountPanel, BorderLayout.CENTER);

                    // Make the account frame visible
                    accountFrame.setVisible(true);

                    // Dispose the current frame
                    dispose();
                }
            });
        }
    }

    public class NotificationPanel extends JPanel {
    private JTextArea notificationTextArea;
    private JButton notificationBtn_back_to_account;

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
    
            notificationBtn_back_to_account = new JButton("Back to Account");
    
            notificationBottomPanel.add(notificationBtn_back_to_account);
    
            add(notificationBottomPanel, BorderLayout.SOUTH);
    
            // Add action listener

            notificationBtn_back_to_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame accountFrame = new JFrame("Account");
                    accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    accountFrame.setSize(800, 600);
                    accountFrame.setLayout(new BorderLayout());

                    // Create a new AccountPanel instance
                    AccountPanel accountPanel = new AccountPanel();
                    accountFrame.add(accountPanel, BorderLayout.CENTER);

                    // Make the account frame visible
                    accountFrame.setVisible(true);

                    // Dispose the current frame
                    dispose();
                }
            });
        }
    }

    public class BudgetPanel extends JPanel {
        private JTextArea budgetTextArea;
        private JButton budgetBtn_view_categories;
        private JButton budgetBtn_add_budget;
        private JButton budgetBtn_add_category;
        private Budget budget = new Budget();
    
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

            budgetBtn_view_categories = new JButton("View Categories");
            budgetBtn_add_budget = new JButton("Add Budget");
            budgetBtn_add_category = new JButton("Add Category");
            
            budgetBottomPanel.add(budgetBtn_add_budget);
            budgetBottomPanel.add(budgetBtn_view_categories);
            budgetBottomPanel.add(budgetBtn_add_category);
    
            add(budgetBottomPanel, BorderLayout.SOUTH);
    
            // Add action listeners
            budgetBtn_add_budget.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add budget logic here
                    String budgetInput = JOptionPane.showInputDialog(null, "Enter how much you're planning on budgeting:");
                    double budgetAmount = Double.parseDouble(budgetInput);
                    budget.setTotalBudget(budgetAmount);
                    budgetTextArea.append("Budget added for: " + budgetAmount + "\n");
                }
            });
    
            budgetBtn_view_categories.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // View categories logic here
                    budgetTextArea.append("Categories:\n");
                    for (String category : budget.getCategories()) {
                        budgetTextArea.append(category + "\n");
                    }
                }
            });

            budgetBtn_add_category.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add category logic here
                    String categoryInput = JOptionPane.showInputDialog(null, "Enter a category:");
                    budget.addCategory(categoryInput);
                    budgetTextArea.append("Category added: " + categoryInput + "\n");
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
        private JButton categoryBtn_add_category;
        private JButton categoryBtn_back_to_account;
    
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
    
            categoryBtn_add_category = new JButton("Add Category");
            categoryBtn_back_to_account = new JButton("Back to Account");
    
            categoryBottomPanel.add(categoryBtn_add_category);
            categoryBottomPanel.add(categoryBtn_back_to_account);
    
            add(categoryBottomPanel, BorderLayout.SOUTH);
    
            // Add action listeners
    
            categoryBtn_add_category.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add category logic here
                    String categoryName = JOptionPane.showInputDialog(null, "Enter category name:");
                    double allocatedAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter allocated amount:"));
                    Category category = new Category(0, categoryName, allocatedAmount);
                    BudgetApp.addCategory(category);
                    categoryTextArea.append("Category added: " + category + "\n");
                    
                }
            });

            categoryBtn_back_to_account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Back to account logic here
                    JFrame accountFrame = new JFrame("Account");
                    accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    accountFrame.setSize(800, 600);
                    accountFrame.setLayout(new BorderLayout());

                    // Create a new AccountPanel instance
                    AccountPanel accountPanel = new AccountPanel();
                    accountFrame.add(accountPanel, BorderLayout.CENTER);

                    // Make the account frame visible
                    accountFrame.setVisible(true);

                    // Dispose the current frame
                    dispose();
                }
            });
        }
    }
    public static void main(String[] args) {
        new MainGUI();
    }
}
