public class User {

    private int userID;
    private String name;
    private String phoneNumber;
    private String password;

    public User(int userID, String name, String phoneNumber, String password) {
        this.userID = userID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number.");
        }
    }

   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) { 
            this.password = password;
        } else {
            System.out.println("Password must be at least 6 characters long.");
        }
    }

  
   
  
}
