package ua.univer.lesson03;

import java.util.Arrays;

public class Program {
    static int countq=0;
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;

            }

            while (array[j] > opora) {
                j--;

            }

            if (i <= j) {//меняем местами
                countq++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    public static void main(String[] args) {
        int count =0;
        int [] arr = {1,2,3,34,4,2,4,2,4,5};
       // count = bubblesort(count, arr);

       // System.out.println(count);

        quickSort(arr,0, arr.length-1);
        
        Arrays.sort(arr);
        Object[] objs = new Object[0];
        Arrays.sort(objs);
        System.out.println(countq);
        System.out.println(Arrays.toString(arr));
    }

    private static int bubblesort(int count, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                count++;
                if(arr[j]> arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return count;
    }

}

