package url_parsing;

import db.ForCrawler;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CalculationRank {
    private static String endURL;

    public void CalculationOfRepetitions(String url, String localgetSiteId) {
        try {
            endURL = Jsoup.connect(url).get().html();                                                             // извлекаем html код из ссылки
        } catch (IOException e) {
            System.out.println("Нет соединения!");
            try {
                endURL = Jsoup.connect(url).get().html();                                                        // вторая попытка извлечения, если нужно
            } catch (IOException e1) {
                System.out.printf("Два раза нет соединения!");
            }
        }

        ArrayList<String> keyWords = ForCrawler.getKeyWords();                                                   // получение из БД ключевых слов, из таблицы Keywords
        String[] line = endURL.split("\n");                                                                      // cоставляем массив строк по переходу на следующую строку
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                               // формат даты
        String dateNow = dateFormat.format(new Date());                                                          // получение даты и всремени в данный момент
        System.out.println("Обновление информации о парсинге url в PAGES...");
        ForCrawler.setPagesInfo(url, ForCrawler.getSiteId(localgetSiteId), dateNow);                             // добавление в БД: url сканируемой страницы, "имя сайта" и даты и всремени в данный момент
        for (String z : keyWords) {                                                                              // цикл по ключевым словам
            int count = 0;
            for (String x : line) {                                                                              // цикл проверки ключевых слов в массиве строк
                if (x.contains(z + " ")) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("Добавление новой записи по персоне!");
                ForCrawler.setPersonalPageRank(ForCrawler.getPersonId(z), ForCrawler.getPageId(url), count);     // добавление в БД: PersonID, PageID и количество совпадений
                System.out.println("Добавили запись в БД.");
            } else {
                System.out.println("Совпадений по слову " + z + " не найдено.");
            }
        }
    }
}
