package ua.univer.lesson12;

import ua.univer.lesson11.FilePath;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Arrays;



public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Droid[] droids = {new Droid("R2D1", 100, 95, new Army("A")),
                new Droid("R2D2", 110, 190, new Army("B")),
                new Droid("R2D3", 105, 90, new Army("C"))

        };
        for (var droid : droids) {
            droid.addWeapons("Gun");
        }

//        for (var droid : droids) {
//            System.out.println(droid);
//        }

       //       writeDroidToCSV(droids);
//        Droid[] droidsFromTxt = getDroidFromCSV(FilePath.pathDir + "droids1.csv");
//        for (var droid : droidsFromTxt) {
//            System.out.println(droid);
//        }
      //    writeDroidsByOne(droids);
      //  writeArrayDroids(droids);
        writeXMLArrayDroids(droids);

 //       Droid[] droidsFromFile =  getArrayDroids();
//        Droid.setArmy(new Army("D"));
//        Droid[] droidsFromFile = getDroidsByOne();
        Droid[] droidsFromFile =  getXMLArrayDroids();
        for (var droid : droidsFromFile) {
            System.out.println(droid);
        }
    }

    private static Droid[] getDroidsByOne() throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(
                new FileInputStream("droids.dat"));
        int count = in.readInt();
        Droid [] droidsFromFile = new Droid[count];
        for (int i = 0; i < droidsFromFile.length; i++) {
            droidsFromFile[i]= (Droid)in.readObject();
        }
        in.close();
        return droidsFromFile;
    }

    private static Droid [] getArrayDroids() throws IOException, ClassNotFoundException {
        ObjectInputStream in= new ObjectInputStream(
                new FileInputStream("droids1.dat"));
        Droid [] droidsFromFile = (Droid[])in.readObject();
        in.close();
        return droidsFromFile;
    }

    private static Droid [] getXMLArrayDroids() throws IOException, ClassNotFoundException {
        XMLDecoder in= new XMLDecoder( new ObjectInputStream(
                new FileInputStream("droids1.xml")));
        Droid [] droidsFromFile = (Droid[])in.readObject();
        in.close();
        return droidsFromFile;
    }

    private static void writeArrayDroids(Droid[] droids) throws IOException {
        try( ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("droids1.dat"));){
                out.writeObject(droids);
        }
    }
    private static void writeXMLArrayDroids(Droid[] droids) throws IOException {
        try(XMLEncoder out = new XMLEncoder(new ObjectOutputStream(
                new FileOutputStream("droids1.xml")))){
            out.writeObject(droids);
        }
    }
    private static void writeDroidsByOne(Droid[] droids) throws IOException {
        try( ObjectOutputStream out = new ObjectOutputStream(
                 new FileOutputStream("droids.dat"));){
            out.writeInt(droids.length);
         for (var droid : droids) {
             out.writeObject(droid);
         }
        }
    }

    private static Droid[] getDroidFromTxT(String filename) throws IOException {
        Droid[] droids = new Droid[10];
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(" ");
                Droid droid = new Droid(
                        words[0],
                        Integer.parseInt(words[1]),
                        Integer.parseInt(words[2]),
                        new Army(words[3])
                );
                for (int i = 0; i < Integer.parseInt(words[4]); i++) {
                    droid.addWeapons(words[5 + i]);
                }
                droids[count++] = droid;
            }
        }
        return Arrays.copyOf(droids, count);
    }

    private static void writeDroidToTxt(Droid[] droids) throws IOException {
        try (PrintWriter br = new PrintWriter(new FileWriter(FilePath.pathDir + "droids.txt"))) {
            for (var droid : droids) {
                br.println(droid.toTxt(" "));
            }
        }
    }

    private static Droid[] getDroidFromCSV(String filename) throws IOException {
        Droid[] droids = new Droid[20];
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(";");
                Droid droid = new Droid(
                        words[0],
                        Integer.parseInt(words[1]),
                        Integer.parseInt(words[2]),
                        new Army(words[3])
                );
                for (int i = 0; i < Integer.parseInt(words[4]); i++) {
                    droid.addWeapons(words[5 + i]);
                }
                droids[count++] = droid;
            }
        }
        return Arrays.copyOf(droids, count);
    }

    private static void writeDroidToCSV(Droid[] droids) throws IOException {
        try (PrintWriter br = new PrintWriter(new FileWriter(FilePath.pathDir + "droids.csv"))) {
            for (var droid : droids) {
                br.println(droid.toTxt(";"));
            }
        }
    }
}
