package ua.univer.lesson14;

import ua.univer.lesson12.Army;
import ua.univer.lesson12.Droid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

//@FunctionalInterface
//interface ICalc{
//    double oper(double x,double y);
//}
//interface IStr{
//    String oper(String s);
//}



public class Program {
//    public static double sum(double x, double y){
//        return x+y;
//    }
//    public static double multy(double x, double y){
//        return x*y;
//    }
//    public static double div(double x, double y){
//        return x/y;
//    }
    public static void main(String[] args) {
      //  testLambda();
      Droid[] droids   = {
              new Droid("A", 120,250, new Army("A")),
              new Droid("D", 100,220, new Army("A")),
              new Droid("C", 100,200, new Army("A")),
              new Droid("B", 100,210, new Army("A")),
      };
        Arrays.sort(droids, Comparator.comparingInt(Droid::getArmorAmount).thenComparingInt(Droid::getWeaponsAmount).reversed());
        System.out.println(Arrays.toString(droids));

        List<String> strings = Arrays.asList(" as,dfd dgf ","2,3434 ", " etrRTRR,4565 ");
        strings.stream()
                .map((s) -> s.trim())
                .map((s) -> s.replace(",","."))
                .forEach(System.out::println);
    }

    private static void testLambda() {
        double x = 10;
        double y = 20;
//        System.out.println(sum(x,y));
//        System.out.println(multy(x,y));
//        System.out.println(div(x,y));

        BiFunction<Double, Double, Double> sum = (a, b) -> a+b;
        BiFunction<Double, Double, Double> multy = (a,b) -> a*b;
        BiFunction<Double, Double, Double> div = (a,b) -> a/b;

        System.out.println(sum.apply( x,y));
        System.out.println(multy.apply(x,y));
        System.out.println(div.apply(x,y));

        System.out.println(sum.apply(10.0,11.0));
        System.out.println(sum.apply(34.0,3.0));

        List<BiFunction<Double, Double, Double>> list = new ArrayList<>();
        list.add((a,b) -> a+b);
        list.add((a,b) -> a*b);
        list.add(div);
        list.add(sum);
        list.forEach(
                (calc)->System.out.println(calc.apply(10.0,20.0))
        );


        List<Function<String, String>> listStr = new ArrayList<>();
        listStr.add((s) -> s.trim());
        listStr.add((s) -> s.toLowerCase());
        listStr.add((s) -> s.replace(",","."));
        listStr.forEach(
                (e)-> System.out.println(e.apply(" as,dfd dgf "))
        );
        System.out.println(listStr.get(2).apply(listStr.get(0).apply(" 1,2 ")));


        List<String> strings = Arrays.asList(" as,dfd dgf ");
        strings.stream()
                        .map((s) -> s.trim())
                        .map((s) -> s.replace(",","."))
                        .forEach(System.out::print);
    }
}
