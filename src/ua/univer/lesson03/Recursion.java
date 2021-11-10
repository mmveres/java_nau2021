package ua.univer.lesson03;

public class Recursion {
    static int count =0;
    // n! = n* (n-1)!
    public static int fact(int n){
        if(n== 0|| n== 1)
            return 1;
        return n*fact(n-1);
    }
    // fib(n) = fib(n-1)+fib(n-2)
    public static int fib(int n){
        count++;
        if(n== 0|| n== 1) return 1;
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        fib(10);
        System.out.println(count++);
    }
}
