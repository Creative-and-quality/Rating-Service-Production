package db.control;

import db.model.Persons;

import java.util.Collection;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public class PersonDao implements SqlDao<Persons> {
    @Override
    public boolean update(Persons sql) {
        return false;
    }

    @Override
    public boolean delete(Persons sql) {
        return false;
    }

    @Override
    public boolean insert(Persons sql) {
        return false;
    }

    @Override
    public Collection<Persons> select() {
        System.out.println("Получили список Персон из справочника пользователя.");
        return null;
    }
}
