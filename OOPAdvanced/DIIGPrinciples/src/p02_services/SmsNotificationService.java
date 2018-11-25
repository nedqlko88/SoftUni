package p02_services;

public class SmsNotificationService implements NotificationService{
private boolean isActive;

    public SmsNotificationService() {
       isActive = true;
    }

    @Override
    public void sendNotification() {
        System.out.println("SMS NOTIFICATION");
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
