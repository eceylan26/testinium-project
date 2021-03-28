package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.repositories.BookRepository;
import com.testinium.bookstore.repositories.BookStoreRepository;
import com.testinium.bookstore.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByBookStoreId(int id) {
        return bookRepository.findAllBookByBookStoreId(id);
    }

    @Override
    public List<Book> findByCategoryId(int id) {
        return bookRepository.findAllBookByCategoryId(id);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteFromBookStoreById(int bookId,int bookStoreId) {
        bookRepository.deleteBookFromBookStoreById(bookId,bookStoreId);
    }

    @Override
    public Book updateById(Book book) {
        return null;
    }
}
