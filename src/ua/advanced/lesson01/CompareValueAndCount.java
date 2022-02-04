package ua.advanced.lesson01;

import java.util.Arrays;
import java.util.Comparator;

class Dog implements Comparable<Dog>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Dog d) {
        return name.compareTo(d.name);
    }

    @Override
    public String toString() {
        return "\nDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class CompareValueAndCount {
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        System.out.println(countGreaterThan(arr,4));
        String[] str = {"a","b","c","d"};
        System.out.println(countGreaterThan(str,"a"));

        Dog[] dogs = {
                new Dog("Bob11", 15),
                new Dog("Bob2", 6),
                new Dog("Bob13", 17),
                new Dog("Bob4", 8)
        };
        System.out.println(countGreaterThan(dogs,new Dog("Bob2", 6)));
        Arrays.sort(dogs, Comparator.comparingInt(Dog::getAge));
        System.out.println(Arrays.toString(dogs));
    }
}