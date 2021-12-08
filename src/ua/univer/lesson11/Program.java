package ua.univer.lesson11;

import java.io.*;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws IOException {
        //     testFile();
        //     testFile2();
       // int[] arr = {1, 2, 3, 4, 5, 6, 7};
      //  writeArrToTxt(arr);
      //  writeArrToBin(arr);
      //  writeArrToCsv(arr);

        int [] arr1 = getArrFromCsv();
        System.out.println(Arrays.toString(arr1));
    }

    private static int[] getArrFromCsv() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FilePath.pathDir+"arr.csv"))){
           String text = br.readLine();
           String [] words = text.split(";");
           int[] arr1 = new int[words.length];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = Integer.parseInt(words[i]);
            }
            return arr1;
        }
    }

    private static void writeArrToCsv(int[] arr) throws IOException {
        try (FileWriter fw = new FileWriter(FilePath.pathDir + "arr" + ".csv")) {
            for (int i = 0; i < arr.length; i++) {
                fw.write(i+";");
            }
        }
    }

    private static void writeArrToBin(int[] arr) throws IOException {
        try (FileWriter fw = new FileWriter("resource" + File.separator + "arr" + ".bin")) {
            for (int i = 0; i < arr.length; i++) {
                fw.write(i);
            }
        }
    }

    private static void writeArrToTxt(int[] arr) throws IOException {
        try (FileWriter fw = new FileWriter("resource" + File.separator + "arr" + ".txt")) {
            for (int i = 0; i < arr.length; i++) {
                fw.write(i+" ");
            }
        }
    }

    private static void testFile2() throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        File f1 = new File("resource" + File.separator + "arr");
        f1.mkdir();
        for (int i = 0; i < arr.length; i++) {
            try (FileWriter fw = new FileWriter("resource" + File.separator + "arr" + File.separator + "cell" + i + ".txt")) {
                fw.write(String.valueOf(i));
            }
        }
    }

    private static void testFile() throws IOException {
        System.out.println("Enter value");
        File f1 = new File("resource" + File.separator + "n3.txt");
        FileWriter fw = new FileWriter(f1);
        fw.write("1 2 3 4");
        fw.close();
        File dir = new File("resource");
        if (dir.isDirectory())
            System.out.println(Arrays.toString(dir.list()));
    }
}
