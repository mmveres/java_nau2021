package ua.advanced.lesson01;

import java.util.ArrayList;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        Class c3 = new ArrayList().getClass();
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c1.getClass());
        System.out.println(c2.getClass());
        System.out.println(c3.getClass());
    }
}