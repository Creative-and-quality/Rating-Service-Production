package control;

import model.KeyWords;
import model.Persons;

import java.util.Collection;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public class KeyWordsDao implements SqlDao<KeyWords> {
    @Override
    public boolean update(KeyWords sql) {
        return false;
    }

    @Override
    public boolean delete(KeyWords sql) {
        return false;
    }

    @Override
    public boolean insert(KeyWords sql) {
        return false;
    }

    @Override
    public Collection<KeyWords> select() {
        System.out.println("Получили список ключевых слов по персоне.");
        return null;
    }
    public Collection<KeyWords> selectPerson(Persons persons) {
        System.out.println("Получили список ключевых слов по персоне.");
        return null;
    }
}
