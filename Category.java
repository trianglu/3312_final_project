public class Category {

    private int categoryID;
    private String categoryName;
    private double allocatedAmount;

    public Category() {
        this.categoryID = 0;
        this.categoryName = "";
        this.allocatedAmount = 0.0;
    }
  
    public Category(int categoryID, String categoryName, double allocatedAmount) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.allocatedAmount = allocatedAmount;
    }
   
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }


}
