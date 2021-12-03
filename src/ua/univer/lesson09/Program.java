package ua.univer.lesson09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {


     //   printdate();
        Scanner sc = new Scanner(new File("text1.csv"));
     //   Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //String str = "mama mila ramu mila mama";
        String [] words = str.split(";");
        System.out.println(Arrays.toString(words));
        double sum = 0;
        for (int i = 0; i < words.length; i++) {
            sum+=Double.parseDouble(words[i].replace(",","."));
        }
        System.out.println(sum);
    }

    private static void printdate() {
        int year = 2010, month = 10, day = 10;
        int hour = 10, minute = 10, second = 10;
        StringBuilder dateStrBuild = new StringBuilder().append(year).append("-").append(month).append("-").append(day).append(" ")
                .append(hour).append(":").append(minute).append(":").append(second);

        System.out.println(dateStrBuild.capacity()+"/"+dateStrBuild.length());

        String strdate = dateStrBuild.toString();
        System.out.println(strdate.length());
    }
}
