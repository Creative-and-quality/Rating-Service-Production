package control;

import java.util.Collection;

/**
 * Created by d.zhuchkov on 27.06.2016.
 */
public interface SqlDao<T> {
    public boolean update(T sql);

    public boolean delete(T sql);

    public boolean insert(T sql);

    public Collection<T> select();
}
