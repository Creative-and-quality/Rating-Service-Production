package db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KeyWordsDao {

    private String selectSitesSql() {
        return "SELECT Name FROM Keywords;";
    }

    private String selectPersonIDSql(String keyWords) {
        return String.format("SELECT PersonID FROM Keywords WHERE Name='%1$s';", keyWords);
    }

    public Integer getPersonId(String keyWord) {
        ArrayList<String> personId = DBConnector.getInstance().executeSelect(selectPersonIDSql(keyWord));
        return Integer.parseInt(personId.get(0));
    }

    public ArrayList<String> select() {
        return DBConnector.getInstance().executeSelect(selectSitesSql());
    }
}
