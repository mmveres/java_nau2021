package ua.univer.lesson11.kmda;

import ua.univer.lesson11.FilePath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class UserKMDAHelper {
    public static List<User> getUserFromCsv(String filename) throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FilePath.pathDir + filename, Charset.forName("WINDOWS-1251")))) {
            br.readLine();
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(";");
                users.add(new User(
                        words[0],
                        words[1],
                        Double.parseDouble(words[2].replace(",", "."))
                ));
            }
        }
        return users;
    }

    public static List<User> getUserFromURL(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), Charset.forName("WINDOWS-1251")))) {
            br.readLine();
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(";");
                users.add(new User(
                        words[0],
                        words[1],
                        Double.parseDouble(words[2].replace(",", "."))
                ));
            }
        }
        return users;
    }


    public static List<User> getUserWithMaxSalary(List<User> users){
        List<User> maxSalaryUsers = new ArrayList<>();
        User maxSalayUser = users.get(0);
        for (var user: users) {
            if (maxSalayUser.getSalary()<user.getSalary())
                maxSalayUser = user;
        }
        for (var user: users) {
            if (maxSalayUser.getSalary()==user.getSalary())
                maxSalaryUsers.add(user);
        }
        return maxSalaryUsers;
    }
}
