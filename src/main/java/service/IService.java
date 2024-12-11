package service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    void add(T object);

    T findById(int id);

    void update(T object);

    void remove(int id);
}
