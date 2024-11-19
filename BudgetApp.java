public class BudgetApp {
    public static Account account;

    public static void createAccount() {
        account = new Account();
    }

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account newAccount) {
        account = newAccount;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public double getBalance() {
        return account.getBalance();
    }

    public String getProfile() {
        return account.getProfile();
    }

    public void setProfile(String newProfile) {
        account.setProfile(newProfile);
    }

    public static void main(String[] args) {
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Profile: " + account.getProfile());
    }
}
