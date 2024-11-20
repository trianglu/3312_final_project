public class Notification {

    private boolean notificationSetting;
    private String phoneNumber;

    public Notification(boolean notificationSetting, String phoneNumber) {
        this.notificationSetting = notificationSetting;
        this.phoneNumber = phoneNumber;
    }


    public String sendNotification() {
        if (!notificationSetting) {
            return "Notifications are disabled.";
        }

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return "Invalid phone number.";
        }

  
        return "Notification sent to: " + phoneNumber;
    }

    public boolean isNotificationSetting() {
        return notificationSetting;
    }

    public void setNotificationSetting(boolean notificationSetting) {
        this.notificationSetting = notificationSetting;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
