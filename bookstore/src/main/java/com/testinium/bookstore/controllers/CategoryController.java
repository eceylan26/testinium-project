package com.testinium.bookstore.controllers;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.services.BookService;
import com.testinium.bookstore.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Book Api Documentation")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    @ApiOperation("Display all Categories")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/category/id/{id}")
    @ApiOperation("Display Category by ID")
    public Optional<Category> getById(@PathVariable int id) throws NotFoundException {
        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            throw new NotFoundException("id - " + id);
        }

        return categoryService.findById(id);
    }

    @PostMapping("/category")
    @ApiOperation("Add Category")
    public ResponseEntity<Object> addCategory(@RequestBody Category category) {

        categoryService.save(category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/category/id/{id}")
    @ApiOperation("Update Categoriy by ID")
    public ResponseEntity<Object> updateCategory(@PathVariable int id,@RequestBody Category category) {

        categoryService.updateById(id,category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/category/id/{id}")
    @ApiOperation("Delete Category")
    public void deleteCategory(@PathVariable int id) throws NotFoundException {

        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            throw new NotFoundException("id - " + id);
        }
        categoryService.deleteById(id);
    }

}
