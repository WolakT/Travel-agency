package sample;

import java.util.List;

/**
 * Created by RENT on 2017-07-21.
 */
public interface IDao<T> {
    List<T> get();
    int add(T t);
    void update(T t);
    void delete (T t);
}
