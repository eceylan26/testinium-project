package com.testinium.bookstore.controllers;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.BookStore;
import com.testinium.bookstore.services.BookService;
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
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    @ApiOperation("Display all Book")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/book/bookstore/{id}")
    @ApiOperation("Get Book by BookstoreId")
    public ResponseEntity<List<Book>> getAllBooksByBookStoreId(@PathVariable int id){
        return ResponseEntity.ok(bookService.findByBookStoreId(id));
    }

    @GetMapping("/book/category/{id}")
    @ApiOperation("Get Book by BookstoreId")
    public ResponseEntity<List<Book>> getAllBooksByCategoryId(@PathVariable int id){
        return ResponseEntity.ok(bookService.findByCategoryId(id));
    }

    @PostMapping("/book")
    @ApiOperation("Add Book")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {

        bookService.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/book/id/{id}")
    @ApiOperation("Delete Book")
    public void deleteBook(@PathVariable int id) throws NotFoundException {

        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent()) {
            throw new NotFoundException("id - " + id);
        }
        bookService.deleteById(id);
    }

    @DeleteMapping("/book/{bookId}/bookstore/{bookStoreId}")
    @ApiOperation("Delete Book from Bookstore")
    public void deleteBookFromBookStore(@PathVariable int bookId,@PathVariable int bookStoreId) throws NotFoundException {
        bookService.deleteFromBookStoreById(bookId,bookStoreId);
    }



}
