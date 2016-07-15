package db;

public class Facade {
    private SitesDao sitesDao;
    private PagesDao pagesDao;
    private PersonPageRankDao personPageRankDao;
    private KeyWordsDao keyWordsDao;
    private static Facade instance;

    private Facade() {
        this.sitesDao = new SitesDao();
        this.pagesDao = new PagesDao();
        this.personPageRankDao = new PersonPageRankDao();
        this.keyWordsDao = new KeyWordsDao();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public KeyWordsDao getKeyWordsDao() {
        return keyWordsDao;
    }

    public SitesDao getSitesDao() {
        return sitesDao;
    }

    public PagesDao getPagesDao() {
        return pagesDao;
    }

    public PersonPageRankDao getPersonPageRankDao() {
        return personPageRankDao;
    }

}
