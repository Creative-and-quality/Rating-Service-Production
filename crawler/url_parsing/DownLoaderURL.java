package url_parsing;

import db.ForCrawler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DownLoaderURL {

    public DownLoaderURL(ArrayList<String> endArrayURL, String getSiteId) {
        CalculationRank calculationRank = new CalculationRank();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");             // формат даты
        Date currentTime = new Date();                                                         //получаем текущую дату и время
        String localGetSiteId = getSiteId;
        for (int i = 0; i < endArrayURL.size(); i++) {                                         // цикл по всем ссылкам сайта
            String getUrl = endArrayURL.get(i);
            String dateNow = dateFormat.format(new Date());
            if (!ForCrawler.checkURL(getUrl)) {
                System.out.println("URL отсутствует в Бд, добавляем... ");
                ForCrawler.insertNewUrl(getUrl, dateNow);
                System.out.println("Теперь парсим URL... ");
                calculationRank.CalculationOfRepetitions(getUrl, localGetSiteId);
            } else {
                System.out.println("URL существует в БД, проверяем время... ");
                String dateFromDBlastScanString = ForCrawler.getDate(getUrl);
                Date currentDate = null;
                Date dateFromDBlastScan = null;
                try {
                    dateFromDBlastScan = dateFormat.parse(dateFromDBlastScanString);
                    currentDate = dateFormat.parse(dateNow);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if ((currentDate.getTime() - dateFromDBlastScan.getTime()) > 360000) {
                    System.out.println("Пора парсить URL... ");
                    calculationRank.CalculationOfRepetitions(getUrl, localGetSiteId);
                } else {
                    System.out.println("Рано парсить...");
                }
            }
        }
        Date newTime = new Date();                                                         //получаем новое текущее время
        long msDelay = newTime.getTime() - currentTime.getTime();                          //вычисляем разницу
        System.out.println("Время выполнения: " + msDelay + " в ms");
    }
}
