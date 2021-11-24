package ua.univer.lesson04;
import ua.univer.lesson04.a.A;
import java.util.Arrays;

public class Program {
//    public static void swapFunction(int a, int b) {
//        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);
//// Swap n1 with n2
//        int c = a;
//        a = b;
//        b = c;
//        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
//    }
    public static int[] swapFunction(int [] arr) {
        System.out.println("Before swapping(Inside), " + Arrays.toString(arr));
// Swap n1 with n2
        arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;
        int t = arr[0];
        arr[0] = arr[1];
        arr[1] = t;
        System.out.println("After swapping(Inside), " + Arrays.toString(arr));
        return arr;
    }

    public static void swapFunction(Integer a, Integer b) {
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);
// Swap n1 with n2
        int c = a;
        a = b;
        b = c;
        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Integer a = 30;
        Integer b = 45;
        swapFunction(a, b);
//Now, Before and After swapping values will be same here
        System.out.println("After swapping, a = " + a + " and b is " + b);
        int[] arr ={a,b};
        arr = swapFunction(arr);
        System.out.println("After swapping, "+ Arrays.toString(arr));
        A.aaa();
        A a1 = new A().clone();
        Object obj =  new Object();
        System.out.println( Arrays.toString(a1.getClass(). getInterfaces()));

    }
}
