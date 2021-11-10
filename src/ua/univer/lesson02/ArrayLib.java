package ua.univer.lesson02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLib {
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" - ");
        }
        System.out.println();
    }
    public static int getMaxEl(int[] arr) {
        int max_el = arr[0];
        for (var el: arr) {
            if(el> max_el)
                max_el = el;
        }
        return max_el;
    }

    public static int[] getArrFromConsole() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        int i = 0;
        while(true) {
            if (i == arr.length){
                //    arr = copyArr(arr);
                arr = Arrays.copyOf(arr,arr.length*2);
            }
            System.out.println("enter int value "+ i+"/"+arr.length);
            arr[i] = sc.nextInt();
            System.out.println("exit [y]");
            String answer = sc.next();
            if (answer.charAt(0)=='y') break;
            i++;
        }
        return arr;
    }

    public static int[] copyArr(int[] arr) {
        int[] temp = new int[arr.length*2];
//        for (int j = 0; j < arr.length; j++) {
//            temp[j]= arr[j];
//        }
        System.arraycopy(arr,0,temp,0, arr.length);
        return temp;
    }

    public static int[] getArr3FromConsole() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter int value "+ i+"/"+arr.length);
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int[] getArr() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*i;
        }
        return arr;
    }

    public static void printArrForeach(int[] arr) {
        for (var elem: arr) {
            System.out.print(elem + ", ");
        }
    }
}
