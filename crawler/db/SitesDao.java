package db;

import java.util.*;

public class SitesDao {
    private String selectSitesSql() {
        return "SELECT Name FROM Sites;";
    }

    private String selectSiteIDSql(String siteUrl) {
        return String.format("SELECT ID FROM Sites WHERE name='%1$s';",siteUrl);
    }

    public ArrayList<String> select() {
        return DBConnector.getInstance().executeSelect(selectSitesSql());
    }

    public Integer getSiteId(String keyWord) {
        ArrayList<String> pageId = DBConnector.getInstance().executeSelect(selectSiteIDSql(keyWord));
        return Integer.parseInt(pageId.get(0));
    }
}
