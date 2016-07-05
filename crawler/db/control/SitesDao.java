package db.control;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public class SitesDao implements SqlDao<String> {

    @Override
    public boolean update(String sql) {
        return false;
    }

    @Override
    public boolean delete(String sql) {
        return false;
    }

    @Override
    public boolean insert(String sql) {
        return false;
    }

    @Override
    public Collection<String> select() {
        Collection<String> sites = new ArrayList<>();
        sites.add("lenta.ru");
        System.out.println("Получили коллекцию сайтов из справочника!");
        return sites;
    }
}
