package com.pgrlv.dao;

import com.pgrlv.model.Author;
import org.hibernate.Session;

import java.util.List;

public class AuthorDao implements Dao<Author> {

    private Session session;
    public AuthorDao(Session session){
        this.session = session;
    }

    @Override
    public Author getById(Integer id) {
        return session.find(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        return session.createQuery("FROM Author", Author.class).list();
    }

    @Override
    public void save(Author object) {
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
    }

    @Override
    public Author update(Author object) {
        session.beginTransaction();
        Author merged = session.merge(object);
        session.getTransaction().commit();
        return merged;
    }

    @Override
    public void delete(Author object) {
        if (object != null){
            session.beginTransaction();
            session.remove(object);
            session.getTransaction().commit();
        }
    }
}
