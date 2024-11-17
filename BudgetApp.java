public class BudgetApp {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000);
        account.withdraw(500);
        account.setProfile("Savings");
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Profile: " + account.getProfile());
    }
}
