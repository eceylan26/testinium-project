package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.BookStore;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.repositories.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public Optional<BookStore> findById(int id) {
        return bookStoreRepository.findById(id);
    }

    @Override
    public BookStore save(BookStore bookstore) {
        return bookStoreRepository.save(bookstore);
    }

    @Override
    public void deleteById(int id) {
        bookStoreRepository.deleteById(id);
    }

    @Override
    public BookStore updateById(BookStore bookstore,int id) {
        BookStore currentBookStore = bookStoreRepository.getOne(id);

        currentBookStore.setName(bookstore.getName());
        currentBookStore.setCity(bookstore.getCity());
        bookStoreRepository.save(currentBookStore);

        return currentBookStore;
    }
}
