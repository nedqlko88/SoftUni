package p02_services;

public class EmailNotificationService implements NotificationService{
    private boolean isActive;

    public EmailNotificationService() {
        this.isActive = true;
    }

    @Override
    public void sendNotification() {
        System.out.println("EMAIL NOTIFICATION");
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}