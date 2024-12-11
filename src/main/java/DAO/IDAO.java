package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    Connection getConnection() throws SQLException;

    List<T> findAll();

    void add(T object);

    T findByCode(String code);

    void update(T object);

    void remove(int id);
}
