package url_parsing;

import org.jsoup.Jsoup;

import java.io.IOException;


public class GetRobotsTXT {
    private String siteMap;

    GetRobotsTXT(String urlFromDB) {
        String htmlRobots = null;
        try {
            String urlRobots = "https://" + urlFromDB + "/robots.txt";              // Преобразуем "имя" сайта в url ссылку
            htmlRobots = Jsoup.connect(urlRobots).get().html();                     // Получаем по ссылке html код страницы.
            if (htmlRobots.contains("sitemap.xml")) {                               // Если там присутствует sitemap.xml, то
                String[] text = htmlRobots.split(" ");                              // Разбиваем html код на строки, по пробелу, и помещаем все это в массив строк
                for (String x : text) {                                             // Бежим по массиву строк
                    if (x.endsWith(".xml")) {                                       // Если в конце строки присутствует ".xml", то хватаем эту строку и записываем в нашу переменную**
                        System.out.println(x);                                      // Печатаем эту строку, а точнее полученную ссылку на sitemap.xml
                        siteMap = x;                                                // **
                    }
                }
                System.out.println("Нашли sitemap.xml, пытаемся его получить!");    // Радуемся, что карта сайта есть.
            } else {
                System.out.println("Нет соединения с сайтом:" + urlFromDB);         // Скорбим, что карты сайта нет.
            }
        } catch (IOException e) {
            String urlRobots = "http://" + urlFromDB + "/robots.txt";               // Преобразуем "имя" сайта в url ссылку, если с https не получилось.
            try {
                htmlRobots = Jsoup.connect(urlRobots).get().html();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    String getSiteMap() {
        return siteMap;
    }                                                                                // Возвращаем из класса ссылку на sitemap.xml
}
