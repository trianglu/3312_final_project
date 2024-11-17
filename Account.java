public class Account {
    private double balance;
    private String profile;

    public Account() {
        balance = 0;
        profile = "default";
    }

    public double getBalance() {
        return balance;
    }

    public String getProfile() {
        return profile;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void setProfile(String newProfile) {
        profile = newProfile;
    }
}
