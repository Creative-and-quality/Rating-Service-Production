package url_parsing;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class GetSiteMap {
    private ArrayList<String> list = new ArrayList<>();

    public GetSiteMap(String sitemapXML) throws IOException {
        String sitemapHTML;
        try {
            sitemapHTML = Jsoup.connect(sitemapXML).get().html();                  // Получаем по ссылке html код страницы.
            String[] text1 = sitemapHTML.split(" ");                               // Разбиваем html код на строки, по пробелу, и помещаем все это в массив строк
            for (String y : text1) {                                               // Бежим по массиву строк
                if (y.contains(".xml") | y.contains(".gz")) {                      // Если встречаем в строке ".xml" или ".gz"
                    list.add(y);                                                   // то заносим эту строку в коллекцию
                }
            }
        } catch (HttpStatusException e) {
            System.out.println("Не вышло получить sitemap, сервер нас блочит..");
        }
    }

    public ArrayList<String> getList() {
        return list;                                                                // Возвращаем из класса коллекцию ссылок на архивы
    }
}

