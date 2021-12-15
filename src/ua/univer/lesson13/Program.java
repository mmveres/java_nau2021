package ua.univer.lesson13;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.univer.lesson11.kmda.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void getFromUrl(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
       // List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), Charset.forName("WINDOWS-1251")))) {
            br.readLine();
            while (br.ready()) {
                String text = br.readLine();
                System.out.println(text);
                //        String[] words = text.split(";");
       //         users.add(new User(
//                        words[0],
//                        words[1],
//                        Double.parseDouble(words[2].replace(",", "."))
//                ));
           }
        }
    }
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(new File("exchange.xml"));

        // Получаем корневой элемент
        Element root = doc.getDocumentElement();
        if (root.getTagName().equals("exchange")){
            NodeList listCurrency = root.getElementsByTagName("currency");
            for (int i=0; i<listCurrency.getLength(); i++){
                String cc = ((Element)listCurrency.item(i)).getElementsByTagName("cc").item(0).getTextContent();
                String txt = ((Element)listCurrency.item(i)).getElementsByTagName("txt").item(0).getTextContent();
                String rate =  ((Element)listCurrency.item(i)).getElementsByTagName("rate").item(0).getTextContent();
                System.out.println(cc + ", "+txt+" = "+rate);
            }
        }
        }


    }
