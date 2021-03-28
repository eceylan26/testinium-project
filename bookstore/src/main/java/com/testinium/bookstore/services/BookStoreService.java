package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.BookStore;

import java.util.List;
import java.util.Optional;

public interface BookStoreService {
    List<BookStore> findAll();
    Optional<BookStore> findById(int id);
    BookStore save (BookStore bookstore);
    void deleteById(int id);
    BookStore updateById(BookStore bookstore,int id);
}
