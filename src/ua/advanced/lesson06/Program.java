package ua.advanced.lesson06;

import java.util.Arrays;

class Animal{
    public Animal(int age) {
        this.age = age;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Cat extends Animal{

    public Cat(int age) {
        super(age);
    }
}
class WildCat extends Cat{

    public WildCat(int age) {
        super(age);
    }
}
class Mouse extends Animal{

    public Mouse(int age) {
        super(age);
    }
}
public class Program {
    public static void main(String[] args) {
        Animal []animals = {
                new Animal(10),
                new Cat(5),
                new Mouse(2),
                new WildCat(7)
        };
        int countCat =0;
        for (var animal: animals) {
            System.out.println(animal);
            System.out.println(animal.getClass());
            System.out.println(animal.getClass().getName());
            System.out.println(animal.getClass().getSimpleName());
            if (animal instanceof Cat){
                System.out.println("cat " +(++countCat));
            }
            if (animal.getClass() == Cat.class){
                System.out.println("cat.class ");
            }
            if (animal.getClass().getName().equals("ua.advanced.lesson06.Cat")){
                System.out.println("catName.class ");
            }
            System.out.println(Arrays.toString(animal.getClass().getDeclaredFields()));
            System.out.println(Arrays.toString(animal.getClass().getMethods()));
        }

    }
}
