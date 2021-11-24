package ua.univer.lesson04.a;

public class A extends Object implements Cloneable {
    public static void aaa(){}
    public A clone() throws CloneNotSupportedException {
       return (A)super.clone();
    };
}
