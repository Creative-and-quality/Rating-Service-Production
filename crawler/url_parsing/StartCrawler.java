package url_parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class StartCrawler {
    public static void main(String[] args) throws IOException {
        ArrayList<String> sites = db.ForCrawler.getSites();
        System.out.println("CRAWLER v. 0.1 rev. 0.2");
        System.out.println("Authors: Dmitriy Gurov & Dmitriy Zhuchkov.");

        for (String urlFromDB : sites) {
            Date currentTime = new Date();                                                            //получаем текущую дату и время
            GetRobotsTXT getRobotsTXT = new GetRobotsTXT(urlFromDB);                                  // Создаем экземпляр класса GetRobotsTXT, передаем в него "имя" сайта
            GetSiteMap getSiteMap = new GetSiteMap(getRobotsTXT.getSiteMap());                        // Создаем экземпляр класса GetSiteMap, и передаем в него ссылку на sitemap.xml из класса GetRobotsTXT

            ArrayList<String> listMap = getSiteMap.getList();                                         // Присваиваем коллекцию из класса GetSiteMap, коллекции listMap, для удобства :)
            for (String aListMap : listMap) {                                                         // Бежим по коллекции
                OpenGZ.openGZ(aListMap);                                                              // Передаем ссылки на архивы, для их раскрытия
                DownLoaderURL downloaderURL = new DownLoaderURL(OpenGZ.getListURL(), urlFromDB);      // Создаем экземпляр класса DownloaderURL, и передаем туда лист ссылок и "имя сайта".
            }

            Date newTime = new Date();                                                                //получаем новое текущее время
            long msDelay = newTime.getTime() - currentTime.getTime();                                 //вычисляем разницу
            System.out.println("Время выполнения: " + msDelay + " в ms");
        }
    }
}
