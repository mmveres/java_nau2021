package ua.univer.lesson02;

import java.io.File;
import java.util.Arrays;

public class Program {
    public static void test1(){
        int[] arr = new int[10];
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[]{1,2,3};

        Object[] objects = {
                new Integer(1),
                new String("Hello"),
                new Double(3.14),
                new Boolean(true),
                new Object(),
                new int[12][11][10],
                new Thread(),
                new File("...")
        };

        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i].getClass());
        }
    }

    public static void main(String[] args) {

        int[] arr = ArrayLib.getArr();
        System.out.println(Arrays.toString(arr));
        int max_el = ArrayLib.getMaxEl(arr);
        System.out.println(max_el);
        ArrayLib.printArr(arr);
 //       printArrForeach(arr);

        int[][] matrix = {
                {11,12,13,14},
                {21,22,23,24,25},
                {31,32,33}
        };

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(matrix[1].length);
        System.out.println(matrix[2].length);

        System.out.println(matrix);
        System.out.println(matrix[0]);
        System.out.println(matrix[1]);
        System.out.println(matrix[2]);

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));


        int [] temp = matrix[0];
        matrix[0] = matrix[1];
        matrix[1] = temp;

        MatrixLib.printMatrix(matrix);

        int[][]m = new int[10][10];
        MatrixLib.fillMatrix(m);
        MatrixLib.printMatrix(m);


        int[] m1 =MatrixLib.getFlatMatrix(m);
        System.out.println(Arrays.toString(m1));
    }
}
