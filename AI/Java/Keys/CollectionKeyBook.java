package sample.Keys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Aleksandr on 29.06.2016.
 */
public class CollectionKeyBook {
    String line;
    private ObservableList<Keys> keyList = FXCollections.observableArrayList();


    public void add(Keys key) {
        keyList.add(key);
    }

    public void delete(Keys key) {
        keyList.remove(key);
    }

    public ObservableList<Keys> getkeysList() {
        return keyList;
    }

    public void fillTestKeysData(){
        addToTable();
//        keyList.add(new Keys("Медведев"));
//        keyList.add(new Keys("Медведеву"));
//        keyList.add(new Keys("Медведева"));
//        keyList.add(new Keys("Медведевым"));
//        keyList.add(new Keys("Медведевому"));

    }
    public void addToTable(){
        String l =  getJSON();
//        String l =  getLine();
        String[] lines = l.split(",");
        System.out.println(lines.length);
        for (int i = 0; i < lines.length; i++) {
            int pos = lines[i].indexOf(":");
            //вычленяем имя атрибута из подстроки
            String attributeName= lines[i].substring(0,pos);
            //вычленяем значение атрибута
            String value = lines[i].substring(pos+1,lines[i].length());
            String value2 = value.substring(0 , value.length() - 1);
            //вывод на экран вычлененных значений в нужном нам формате.
//            System.out.println(attributeName + " - " + value);
            if(lines[i].contains("Id")){
                System.out.println("Id: " + value);
            }
            else if(lines[i].contains("Name")){
                if(i == lines.length -1) {
                    System.out.println("Name: " + value.substring(1, value.length()));
                    String name = value.substring(1, value.length() - 1);
                    keyList.add(new Keys(name));
                } else{
                    System.out.println("Name: " + value.substring(1, value.length()));
                    String name = value.substring(1, value.length() - 1);
                    keyList.add(new Keys(name));
                }
            }
        }
    }
    public String getJSON() {
        String urle =  "http://sashich.teperev.ru/api/keyword?app_key=lkshdGtLniBI86786aSbi74765ffhjjhbdf654ds";
        try {
            URL url = new URL(urle);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setConnectTimeout(30000);
            con.connect();
            int resp = con.getResponseCode();
            System.out.println(resp);
            if(resp == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
//                    line = br.readLine();
                    sb.append(line);
                    sb.append("\n");
                    System.out.println(line);
//                    setLine(line);
                }
                br.close();
                return sb.toString();
            } else {
                System.out.println("Что-то пошло не так");
            }
        } catch(Exception e) { e.printStackTrace(); }
        return null;
    }
}
