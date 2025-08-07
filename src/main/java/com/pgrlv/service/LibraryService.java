package com.pgrlv.service;

import com.pgrlv.dao.AuthorDao;
import com.pgrlv.dao.BookDao;
import com.pgrlv.dao.ReaderDao;
import com.pgrlv.model.Author;
import com.pgrlv.model.Book;
import com.pgrlv.model.Reader;
import org.hibernate.Session;

import java.util.List;

public class LibraryService {

    private Session session;
    private AuthorDao authorDao;
    private BookDao bookDao;
    private ReaderDao readerDao;
    public LibraryService(Session session){
        this.session = session;
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

    public List<Book> getAllBooks(){
        return bookDao.getAll();
    }

    public void addReader(String name){
        Reader reader = new Reader();
        reader.setName(name);
        readerDao.save(reader);
    }

    public Reader getReader(String name){
        return readerDao.getByName(name);
    }

    public boolean checkOutBook(Reader reader, Book book){
        if (book.getCount() <= 0 || reader.getBooks().contains(book)){
            return false;
        }
        bookDao.take(book);
        readerDao.addBook(reader, book);
        return true;
    }

    public void returnBook(Reader reader, Book book){
        bookDao.returnOne(book);
        readerDao.removeBook(reader, book);
    }
}
