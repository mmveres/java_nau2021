package ua.univer.lesson11.kmda;

import ua.univer.lesson11.FilePath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {

     //  List<User> users = UserKMDAHelper.getUserFromCsv("lipen-2019.csv");
        List<User> users = UserKMDAHelper.getUserFromURL("https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/59cb6066-1fac-41ed-a571-811db551c75b/download/zp-lupen-2019.csv");
        System.out.println(UserKMDAHelper.getUserWithMaxSalary(users));
    }



}
