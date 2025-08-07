package com.pgrlv.service;

import com.pgrlv.dao.AuthorDao;
import com.pgrlv.dao.BookDao;
import com.pgrlv.dao.ReaderDao;
import com.pgrlv.model.Author;
import com.pgrlv.model.Book;
import org.hibernate.Session;

import java.util.List;

public class LibraryService {

    private AuthorDao authorDao;
    private BookDao bookDao;
    private ReaderDao readerDao;
    public LibraryService(Session session){
        authorDao = new AuthorDao(session);
        bookDao = new BookDao(session);
        readerDao = new ReaderDao(session);
    }

    public void addAuthor(String name){
        Author author = new Author();
        author.setName(name);
        authorDao.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorDao.getAll();
    }

    public void addBook(Book book){
        bookDao.save(book);
    }
}
