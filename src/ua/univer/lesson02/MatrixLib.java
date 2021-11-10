package ua.univer.lesson02;

public class MatrixLib {
    public static int[] getFlatMatrix(int[][] m) {
        int[]m1 = new int[10*10];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m1[i* m[i].length+j] = m[i][j];
            }
        }
        return m1;
    }

    public static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i*j;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(var row : matrix){
            for(var cell : row){
                System.out.print(cell+"\t");
            }
            System.out.println();
        }
    }
}
