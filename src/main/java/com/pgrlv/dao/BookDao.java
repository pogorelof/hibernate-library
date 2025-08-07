package com.pgrlv.dao;

import com.pgrlv.model.Book;

import java.util.List;

public class BookDao implements Dao<Book>{
    @Override
    public Book getById(Integer id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public void save(Book object) {

    }

    @Override
    public Book update(Book object) {
        return new Book();
    }

    @Override
    public void delete(Book object) {

    }
}
