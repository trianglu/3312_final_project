public class Income {
    private int incomeId;
    private double salary;
    private double frequency;

    public Income(int incomeId, double salary) {
        this.incomeId = incomeId;
        this.salary = salary;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getIncomeDescription() {
        return "Income ID: " + incomeId + ", Salary: $" + salary;
    }
}
