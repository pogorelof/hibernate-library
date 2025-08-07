package com.pgrlv.service;

import com.pgrlv.dao.AuthorDao;
import com.pgrlv.dao.BookDao;
import com.pgrlv.dao.ReaderDao;
import com.pgrlv.model.Author;
import com.pgrlv.model.Book;
import com.pgrlv.model.Reader;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final ReaderDao readerDao;
    public LibraryService(AuthorDao authorDao, BookDao bookDao, ReaderDao readerDao){
        this.authorDao = authorDao;
        this.bookDao = bookDao;
        this.readerDao = readerDao;
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

    public void deleteBook(Book book){
        bookDao.deleteConnections(book);
        bookDao.delete(book);
    }

    public List<Book> getAllBooks(){
        return bookDao.getAll();
    }

    public void addReader(String name){
        Reader reader = new Reader();
        reader.setName(name);
        reader.setBooks(new ArrayList<>());
        readerDao.save(reader);
    }

    public Reader getReader(String name){
        Reader reader = readerDao.getByName(name);
        if (reader == null){
            throw new IllegalArgumentException("Читатель не найден: " + name);
        }
        return reader;
    }

    public void deleteReader(Reader reader){
        List<Book> books = reader.getBooks();
        for (Book book : books) {
            bookDao.returnOne(book);
        }
        readerDao.delete(reader);
    }

    public boolean checkOutBook(Reader reader, Book book){
        if (book.getCount() <= 0){
            return false;
        }

        if (reader.getBooks() != null){
            if (reader.getBooks().contains(book)){
                return false;
            }
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
