package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {

    void create(T entity);

    void saveOrUpdate(T entity);

    void delete(T entity);

    void delete(Serializable id);

    List<T> findAll();

    List<T> findAllByExample(T entity);

    T findById(Serializable id);

    void clear();

    void flush();

}
