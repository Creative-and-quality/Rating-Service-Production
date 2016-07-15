package url_parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;


public class OpenGZ {
    private static StringBuffer result = new StringBuffer();
    private static ArrayList<String> listURL = new ArrayList<>();

    public static void openGZ(String s) {
        URL url;
        try {
            url = new URL(s);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();                      // Установка соединения по ссылке
            GZIPInputStream gzipInputStream = new GZIPInputStream(connection.getInputStream());           // Передача потока из, этого соединения, в поток разархивации
            BufferedReader rd = new BufferedReader(new InputStreamReader(gzipInputStream));               // Передаем разархивированный поток на считывание
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line).append("\n");                                                         // Составляем строку из потока с пореходом на следующую строку
            }
            connection.disconnect();                                                                      // Закрываем соединение
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] resultZ = result.toString().split("<loc>");                                              // Разбиваем строку по сочетанию символов <loc> и помещаем в строковый массив
        for (String q : resultZ) {
            String[] ss = q.split("</loc>");                                                              // Разбиваем строки, из массива строк по сочетанию символов </loc> и помещаем в строковый массив
            if (ss[0].startsWith("htt")) {                                                                // Если строка начинается с htt, записываем ее в список
                if (ss[0].contains("/2016")) {
                    listURL.add(ss[0]);
                }
            }
        }
    }

    public static ArrayList<String> getListURL() {
        return listURL;                                                                                   // Массив всех ссылок сайта
    }
}
