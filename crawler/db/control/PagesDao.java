package db.control;

import db.model.Pages;
import db.model.Sites;

import java.util.Collection;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */

public class PagesDao implements SqlDao<Pages> {
    @Override
    public boolean update(Pages sql) {
        return false;
    }

    @Override
    public boolean delete(Pages sql) {
        return false;
    }

    @Override
    public boolean insert(Pages sql) {
        return false;
    }

    @Override
    public Collection<Pages> select() {
        return null;
    }

    public Collection<Pages> selectPagesFromSite(Sites sites) {
        System.out.println("Получаем все ссылки из БД по конкретному сайту.");
        return null;
    }
}
