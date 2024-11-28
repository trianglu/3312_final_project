import java.util.ArrayList;

public class Account {
    private double balance;
    private String profile;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<String> categories = new ArrayList<String>();

    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        balance = 0;
        profile = "Profile: " + firstName + " " + lastName + ", " + email;
    }

    public Account() {
        balance = 0;
        profile = "Profile: " + firstName + " " + lastName + ", " + email;
    }

    public double getBalance() {
        return balance;
    }

    public String getProfile() {
        return profile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addIncome(Income income) {
        balance += income.getAmount();
    }

    public void addCategory(Category category) {
        categories.add(category.getCategoryName());
        balance -= category.getAllocatedAmount();
    }

    public ArrayList<String> getCategories() {
        
        for (String category : categories) {
            categories.add(category);
        }
        return categories;
    }
}
