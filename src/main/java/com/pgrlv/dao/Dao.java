package com.pgrlv.dao;

import java.util.List;

public interface Dao<T> {
    T getById(Integer id);
    List<T> getAll();
    void save(T object);
    T update(T object);
    void delete(T object);
}
