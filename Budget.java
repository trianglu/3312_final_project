import java.util.ArrayList;
import java.util.List;

public class Budget {

    private double totalBudget;
    private List<String> categories;   
    private double totalSpent;         

    public Budget() {
        this.totalBudget = 0.0;
        this.categories = new ArrayList<>();
        this.totalSpent = 0.0;
    }
    public Budget(double totalBudget) {
        this.totalBudget = totalBudget;
        this.categories = new ArrayList<>();
        this.totalSpent = 0.0;
    }

   
    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }


    public void addCategory(String category) {
        if (!categories.contains(category)) {
            categories.add(category);
        } else {
            System.out.println("Category already exists.");
        }
    }


    public void removeCategory(String category) {
        if (categories.contains(category)) {
            categories.remove(category);
        } else {
            System.out.println("Category not found.");
        }
    }


    public double checkRemaining() {
        return totalBudget - totalSpent;
    }


    public void spendAmount(double amount) {
        if (amount > 0 && totalSpent + amount <= totalBudget) {
            totalSpent += amount;
        } else {
            System.out.println("Invalid spending amount. Either the amount is negative or exceeds the available budget.");
        }
    }

    public List<String> getCategories() {
        return categories;
    }


    public double getTotalSpent() {
        return totalSpent;
    }

}
