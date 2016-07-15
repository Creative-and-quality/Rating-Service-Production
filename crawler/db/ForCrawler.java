package db;

import java.util.*;

public class ForCrawler {
    //Получаем все ключевые слова из таблицы Keywords
    public static ArrayList<String> getKeyWords() {
        return Facade.getInstance().getKeyWordsDao().select();
    }

    //Получаем значение поля PersonID по ключевому слову NAME из таблицы Keywords
    public static Integer getPersonId(String keyWord) {
        return Facade.getInstance().getKeyWordsDao().getPersonId(keyWord);
    }

    //получаем ссылки на сайты из справочника
    public static ArrayList<String> getSites() {
        return Facade.getInstance().getSitesDao().select();
    }

    //получаем значение поля ID по значению NAME из таблицы Sites
    public static Integer getSiteId(String nameSite) {
        return Facade.getInstance().getSitesDao().getSiteId(nameSite);
    }

    //делаем проверку ссылки в БД
    public static boolean checkURL(String url) {
        return Facade.getInstance().getPagesDao().checkUrl(url);
    }

    //метод получения даты последнего сканирования конкретной ссылки
    public static String getDate(String url) {
        return Facade.getInstance().getPagesDao().selectDate(url);
    }

    //метод получения PagesId из таблицы Pages
    public static Integer getPageId(String url) {
        return Facade.getInstance().getPagesDao().selectPageId(url);
    }

    //метод занесения информации после парсинга страницы в таблицу Pages
    public static boolean setPagesInfo(String url, Integer siteId, String lastScanDate) {
        return Facade.getInstance().getPagesDao().insert(url, siteId, lastScanDate);
    }

    //метод добавления новой ссылки
    public static boolean insertNewUrl(String url, String date) {
        return Facade.getInstance().getPagesDao().insertNewUrl(url, date);
    }
    
    //метод занесения информации парсинга страницы в таблицу PersonPageRank
    public static boolean setPersonalPageRank(Integer personId, Integer pageId, Integer rank) {
        return Facade.getInstance().getPersonPageRankDao().insert(personId, pageId, rank);
    }
}
