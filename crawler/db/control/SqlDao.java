package db.control;

import java.util.Collection;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */

interface SqlDao<T> {
    public boolean update(T sql);

    public boolean delete(T sql);

    boolean insert(T sql);

    Collection<T> select();
}
