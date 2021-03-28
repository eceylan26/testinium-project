package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.repositories.CategoryRepository;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id)  {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateById(int id,Category category) {
        Category currentCategory = categoryRepository.getOne(id);

        currentCategory.setName(category.getName());
        categoryRepository.save(currentCategory);
        return currentCategory;
    }
}
