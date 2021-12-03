package ua.univer.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;
class ValueNotMarkException extends Exception{
    public ValueNotMarkException(String message) {
        super(message);
    }
}
public class ProgramEx {
    public static BufferedReader br;
    public static Logger logger = Logger.getLogger(ProgramEx.class.getName());
    static {
        br= new BufferedReader(new InputStreamReader( System.in));
        try {
            Handler fh = new FileHandler("prog.log");
            fh.setFormatter(new SimpleFormatter());
            logger.setLevel(Level.SEVERE);
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int[] marks = new int [5];
        for (int i = 0; i < marks.length; i++) {
            System.out.println("marks["+ i +"] = ");
            marks[i] = getMark();
        }

        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
           // logger.log(Level.INFO,""+marks[i]);
        }

        logger.log(Level.INFO, Arrays.toString(marks));

    }

    private static int getMark() {
        while(true)
        try {
            int valueInt = getValueInt();
            logger.log(Level.INFO, "getValueInt() =  " + valueInt);
            if (valueInt < 3 || valueInt > 12)
                throw new ValueNotMarkException("Not Mark");
           return valueInt;
        }catch (ValueNotMarkException e){
          //  System.err.println(e.getMessage());
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    private static int getValueInt() {
        while(true)
        try {
            String value = br.readLine();
            logger.log(Level.INFO, "Enter from console " + value);
            return Integer.parseInt(value);

        }catch (NumberFormatException | IOException e) {
            // System.err.println("Not int");
            logger.log(Level.SEVERE, "Not int " + Arrays.toString(e.getStackTrace()));
        }
    }
}
