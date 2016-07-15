package db;

import java.util.*;

public class PagesDao {

    private String insertSql(String url, String date) {
        return String.format("INSERT INTO Pages(Url, FoundDateTime) values('%1$s', '%2$s');", url, date);
    }

    private String selectPageIdSql(String url) {
        return String.format("SELECT Id FROM Pages WHERE Url='%1$s';", url);
    }

    private String insertUrlInfoSql(String url, Integer siteid, String lastScanDate) {
        return String.format("UPDATE Pages SET SiteID=%1$s, LastScanDate='%2$s' WHERE Url='%3$s';", siteid, lastScanDate, url);
    }

    private String selectDateUrlSql(String url) {
        return String.format("SELECT LastScanDate FROM Pages WHERE Url='%1$s';", url);
    }

    private String checkUrlSql(String url) {
        return String.format("SELECT EXISTS(SELECT * FROM Pages WHERE Url='%1$s');", url);
    }

    public boolean insertNewUrl(String url, String date) {
        return DBConnector.getInstance().executeUpdate(insertSql(url, date));
    }

    public Integer selectPageId(String url) {
        ArrayList<String> pageId = DBConnector.getInstance().executeSelect(selectPageIdSql(url));
        return Integer.parseInt(pageId.get(0));
    }

    public boolean insert(String url, Integer siteId, String lastScanDate) {
        return DBConnector.getInstance().executeUpdate(insertUrlInfoSql(url, siteId, lastScanDate));
    }

    public boolean checkUrl(String url) {
        ArrayList<String> urlCheck = DBConnector.getInstance().executeSelect(checkUrlSql(url));
        int i = Integer.parseInt(urlCheck.get(0));
        return i != 0;
    }

    public String selectDate(String url) {
        ArrayList<String> dateArray = DBConnector.getInstance().executeSelect(selectDateUrlSql(url));
        return dateArray.get(0);
    }
}
