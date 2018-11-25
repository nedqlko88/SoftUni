package p02_services;

public class OnlineStoreOrder implements Order{

    private NotificationService[] notifications;


    public OnlineStoreOrder(NotificationService... services) {
        this.notifications = services;
    }

    @Override
    public void process() {
        for (NotificationService notificationService : this.notifications) {
            if (notificationService.isActive()) {
            notificationService.sendNotification();
            }
        }
    }
}
