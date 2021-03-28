package com.testinium.bookstore.controller;


import com.testinium.bookstore.controllers.BookController;
import com.testinium.bookstore.controllers.BookStoreController;
import com.testinium.bookstore.controllers.CategoryController;
import com.testinium.bookstore.controllers.CityController;
import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.BookStore;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.entities.City;
import com.testinium.bookstore.services.BookService;
import com.testinium.bookstore.services.BookStoreService;
import com.testinium.bookstore.services.CategoryService;
import com.testinium.bookstore.services.CityService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetAllBook_thenReturnBook() throws Exception {

        Book book= Book.builder().name("Harry Potter ve Chamber of Secret").build();


        List<Book> books = Arrays.asList(book);

        Mockito.when(bookService.findAll()).thenReturn(books);

        mockMvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is(book.getName())));

    }


}
