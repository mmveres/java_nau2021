package ua.advanced.lesson06;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter {
    private List<NotificationService> notificationServiceList;

    public NotificationCenter() {
        notificationServiceList = new ArrayList<>();
    }
    public void registerService(NotificationService service){
        notificationServiceList.add(service);
    }
    public void notifyAll(User user, String message) {
// some logic
        for (var service: notificationServiceList) {
            service.sendMessage(user, message);
        }

    }
    public void notify(User user, String message,
                       NotificationService service) {
// some logic
        service.sendMessage(user, message);
    }
}

