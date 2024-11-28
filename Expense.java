public class Expense {

    private int expenceID;
    private double amount;
    private String date;
    private String description;

    public Expense() {
        this.expenceID = 0;
        this.amount = 0.0;
        this.date = "";
        this.description = "";
    }

    public Expense(int expenceID, double amount, String date, String description) {
        this.expenceID = expenceID;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }


    public String getDetails() {
        return "Expense ID: " + expenceID + "\n" +
               "Amount: $" + amount + "\n" +
               "Date: " + date + "\n" +
               "Description: " + description;
    }

  
    public int getExpenceID() {
        return expenceID;
    }

    public void setExpenceID(int expenceID) {
        this.expenceID = expenceID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}