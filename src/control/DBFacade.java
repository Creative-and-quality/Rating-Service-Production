package control;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public class DBFacade {
    private SitesDao sitesDao;
    private PagesDao pagesDao;
    private PersonDao personDao;
    private PersonPageRankDao personPageRankDao;
    private KeyWordsDao keyWordsDao;

    public KeyWordsDao getKeyWordsDao() {
        return keyWordsDao;
    }

    private static DBFacade instance;

    public SitesDao getSitesDao() {
        return sitesDao;
    }

    public PagesDao getPagesDao() {
        return pagesDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public PersonPageRankDao getPersonPageRankDao() {
        return personPageRankDao;
    }

    /*public Facade() {
        this.bookDAO = new BookDAO();
        this.authorDAO = new AuthorDAO();
    }*/

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }
}
