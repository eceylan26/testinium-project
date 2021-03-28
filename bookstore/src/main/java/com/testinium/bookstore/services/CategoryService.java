package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(int id);
    Category save (Category category);
    void deleteById(int id);
    Category updateById(int id,Category category);
}
