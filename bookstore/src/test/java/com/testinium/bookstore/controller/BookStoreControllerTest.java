package com.testinium.bookstore.controller;

import com.testinium.bookstore.controllers.BookStoreController;
import com.testinium.bookstore.controllers.CategoryController;
import com.testinium.bookstore.controllers.CityController;
import com.testinium.bookstore.entities.BookStore;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.entities.City;
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
@WebMvcTest(BookStoreController.class)
public class BookStoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookStoreService bookStoreService;

    @Test
    void whenGetAllBookStores_thenReturnBookStores() throws Exception {

        BookStore bookStore = BookStore.builder().name("İzmir Halk Kütüphanesi")
                .city(new City().builder().name("İzmir").build()).build();

        List<BookStore> bookStories = Arrays.asList(bookStore);

        Mockito.when(bookStoreService.findAll()).thenReturn(bookStories);

        mockMvc.perform(get("/bookstores")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is(bookStore.getName())));

    }

    @Test
    void whenGetBookStore_notExist() throws Exception {

        BookStore bookStore = BookStore.builder().name("İzmir Halk Kütüphanesi").city(new City().builder().name("İzmir").build()).build();

        List<BookStore> bookStories = Arrays.asList(bookStore);

        Mockito.when(bookStoreService.findAll()).thenReturn(bookStories);

        mockMvc.perform(get("/bookstores/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());


    }

}
