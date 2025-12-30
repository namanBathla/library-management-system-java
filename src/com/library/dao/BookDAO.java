package com.library.dao;
import com.library.model.Book;

/*
    BookDAO exists to define a contract.
    BookDAOImpl exists to provide one implementation of that contract.
 */
public interface BookDAO {
    Book getBookById(int bookId);
    boolean addBook(Book book);
    boolean updateBook(int bookId, Book book);
    boolean deleteBook(int bookId);
}
