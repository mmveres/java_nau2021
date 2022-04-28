package ua.advanced.lesson06;

public class NotifyEmail implements NotificationService {
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("Email " +user+" send " + message);
    }
}
