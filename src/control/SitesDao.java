package control;

import model.Sites;
import java.util.Collection;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public class SitesDao implements SqlDao<Sites> {
    @Override
    public boolean update(Sites sql) {
        return false;
    }

    @Override
    public boolean delete(Sites sql) {
        return false;
    }

    @Override
    public boolean insert(Sites sql) {
        return false;
    }

    @Override
    public Collection<Sites> select() {
        System.out.println("Получили коллекцию сайтов из справочника!");
        return null;
    }
}
