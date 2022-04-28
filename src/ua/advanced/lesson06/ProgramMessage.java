package ua.advanced.lesson06;

public class ProgramMessage {
    public static void main(String[] args) {
        NotificationCenter center1 = new NotificationCenter();
        center1.notify(new User("Tom"),"Hello world", new NotifyEmail());
        center1.notify(new User("Tom"), "Hello world", (user, message) -> System.out.println("Text " +user+" send " + message));

        NotificationCenter center2 = new NotificationCenter();
        center2.registerService(new NotifyEmail());
        center2.registerService((user, message) -> System.out.println("File " +user+" send " + message));
        center2.registerService((user, message) -> System.out.println("Facebook " +user+" send " + message));

        center2.notifyAll(new User("Bob"), "Hi");
    }
}
