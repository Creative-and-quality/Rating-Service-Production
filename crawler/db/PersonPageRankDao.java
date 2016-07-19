package db;

public class PersonPageRankDao {

    private String insertSql(Integer personId, Integer pageId, Integer rank) {
        return String.format("REPLACE INTO PersonPageRanks(PersonID, PageID, Rank) values(%1$s, %2$s, %3$s);", personId, pageId, rank);
    }

    public boolean insert(Integer personId, Integer pageId, Integer rank) {
       return DBConnector.getInstance().executeUpdate(insertSql(personId, pageId, rank));
    }
}


