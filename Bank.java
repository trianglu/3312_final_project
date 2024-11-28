import java.util.ArrayList;

public class Bank {
    private int bankID;
    private String bankName;
    private ArrayList<Integer> accountNumbers = new ArrayList<>();
    private int accountNumber;
    private double balance;
    private ArrayList<Double> transactions; 

    
    public Bank(int bankID, String bankName, int accountNumber, double initialBalance) {
        this.bankID = bankID;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialBalance); 
    }

    public void addBankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions.add(initialBalance);
        System.out.println("Account added with number: " + accountNumber + " and balance: " + initialBalance);
    }

    public void removeBankAccount() {
        this.balance = 0;
        System.out.println("Account with number " + accountNumber + " has been removed.");
    }

    
    public void updateBalance(double amount) {
        this.balance += amount;
        this.transactions.add(amount); 
        System.out.println("Balance updated by " + amount + ". New balance: " + this.balance);
    }

    
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Integer> getAccountNumbers() {
        return accountNumbers;
    }

    public void addAccount(int accountNumber) {
        this.accountNumbers.add(accountNumber);
    }
}