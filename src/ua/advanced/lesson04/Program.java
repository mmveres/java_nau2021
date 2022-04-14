package ua.advanced.lesson04;
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start MyThread");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end MyThread");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start MyRunnable");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end MyRunnable");
    }
}
public class Program {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");

        MyThread th1 = new MyThread();
        th1.start();

        Thread th2 = new Thread(new MyRunnable());
        th2.start();

       new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start anonim Thread");

                System.out.println(Thread.currentThread().getName() + " end anonim Thread");
            }
        }.start();

       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName() + " start anonim Runnable");

               System.out.println(Thread.currentThread().getName() + " end anonim Runnable");
           }
       }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start anonim Runnable");
            System.out.println(Thread.currentThread().getName() + " end anonim Runnable");
        }).start();

        th1.join();
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
