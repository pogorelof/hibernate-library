package com.pgrlv;

import com.pgrlv.dao.AuthorDao;
import com.pgrlv.model.Author;
import com.pgrlv.model.Book;
import com.pgrlv.model.Reader;
import com.pgrlv.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

        }
    }
}
