package com.pgrlv.dao;

import com.pgrlv.model.Book;
import com.pgrlv.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class BookDao implements Dao<Book>{

    private Session session;
    public BookDao(Session session){
        this.session = session;
    }

    public boolean take(Book book){
        Integer count = book.getCount();
        if (count <= 0){
            return false;
        }
        book.setCount(count - 1);
        return true;
    }

    @Override
    public Book getById(Integer id) {
        return session.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return session.createQuery("FROM Book ", Book.class).list();
    }

    @Override
    public void save(Book object) {
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
    }

    @Override
    public Book update(Book object) {
        session.beginTransaction();
        Book merged = session.merge(object);
        session.getTransaction().commit();
        return merged;
    }

    @Override
    public void delete(Book object) {
        if (object != null){
            session.beginTransaction();
            session.remove(object);
            session.getTransaction().commit();
        }
    }
}
