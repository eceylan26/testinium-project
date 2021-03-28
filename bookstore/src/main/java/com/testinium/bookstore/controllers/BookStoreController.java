package com.testinium.bookstore.controllers;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.BookStore;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.services.BookStoreService;
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
@Api(value = "BookStore Api Documentation")
public class BookStoreController {

    @Autowired
    BookStoreService bookStoreService;

    @GetMapping("/bookstores")
    @ApiOperation("Get all bookstores")
    public ResponseEntity<List<BookStore>> getAllBookStore() {
        return ResponseEntity.ok(bookStoreService.findAll());
    }

    @GetMapping("/bookstore/id/{id}")
    @ApiOperation("Get BookStores by ID")
    public Optional<BookStore> getBookStoreById(@PathVariable int id) throws NotFoundException {
        Optional<BookStore> category = bookStoreService.findById(id);
        if (!category.isPresent()) {
            throw new NotFoundException("id - " + id);
        }

        return bookStoreService.findById(id);
    }

    @PostMapping("/bookstore")
    @ApiOperation("Add Bookstore")
    public ResponseEntity<Object> addBookStore(@RequestBody BookStore bookStore) {

        bookStoreService.save(bookStore);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookStore.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/bookstore/id/{id}")
    @ApiOperation("Delete BookStore by ID")
    public void deleteBookStore(@PathVariable int id) throws NotFoundException {

        Optional<BookStore> book = bookStoreService.findById(id);
        if (!book.isPresent()) {
            throw new NotFoundException("id - " + id);
        }
        bookStoreService.deleteById(id);
    }

    @PutMapping("/bookstore/id/{id}")
    @ApiOperation("Update BookStore by ID")
    public ResponseEntity<Object> updateBookStore(@PathVariable int id,@RequestBody BookStore bookStore) {

        bookStoreService.updateById(bookStore,id);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookStore.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
