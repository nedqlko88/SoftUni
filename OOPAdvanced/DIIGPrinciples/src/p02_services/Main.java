package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService sms = new SmsNotificationService();
        NotificationService email = new EmailNotificationService();

        Order order = new OnlineStoreOrder(email);
        order.process();
    }
}
