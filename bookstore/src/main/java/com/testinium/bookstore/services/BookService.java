package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    List<Book> findByBookStoreId(int id);
    List<Book> findByCategoryId(int id);
    Optional<Book> findById(int id);
    Book save (Book book);
    void deleteById(int id);
    void deleteFromBookStoreById(int bookId,int bookStoreId );
    Book updateById(Book book);
}
