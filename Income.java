public class Income {

    private int incomeId;
    private double amount;
    private double frequency; 


    public Income(int incomeId, double amount, double frequency) {
        this.incomeId = incomeId;
        this.amount = amount;
        this.frequency = frequency;
    }


    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }


    public int getIncomeId() {
        return incomeId;
    }

    public double getAmount() {
        return amount;
    }

    public double getFrequency() {
        return frequency;
    }


    public void setIncome(double amount) {
        this.amount = amount;
    }


    //public String getIncomeDetails() {
    //    return "Income ID: " + incomeId + "\n" +
    //           "Amount: $" + amount + "\n" +
    //           "Frequency: " + frequency + " times per month";
    }
