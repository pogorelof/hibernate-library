package com.pgrlv.dao;

import com.pgrlv.model.Book;
import com.pgrlv.model.Reader;
import org.hibernate.Session;

import java.util.List;

public class ReaderDao implements Dao<Reader>{

    private Session session;
    public ReaderDao(Session session){
        this.session = session;
    }

    public Reader getByName(String name){
        String hql = "FROM Reader WHERE name = :name";
        return session.createQuery(hql, Reader.class)
                .setParameter("name", name)
                .uniqueResult();
    }

    public void addBook(Reader reader, Book book){
        session.beginTransaction();
        reader.getBooks().add(book);
        session.getTransaction().commit();
    }

    @Override
    public Reader getById(Integer id) {
        return session.find(Reader.class, id);
    }

    @Override
    public List<Reader> getAll() {
        return session.createQuery("FROM Reader", Reader.class).list();
    }

    @Override
    public void save(Reader object) {
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
    }

    @Override
    public Reader update(Reader object) {
        session.beginTransaction();
        Reader merged = session.merge(object);
        session.getTransaction().commit();
        return merged;
    }

    @Override
    public void delete(Reader object) {
        if (object != null){
            session.beginTransaction();
            session.remove(object);
            session.getTransaction().commit();
        }
    }
}
