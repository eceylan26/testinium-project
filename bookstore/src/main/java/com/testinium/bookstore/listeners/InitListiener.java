package com.testinium.bookstore.listeners;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.BookStore;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.entities.City;
import com.testinium.bookstore.services.BookService;
import com.testinium.bookstore.services.BookStoreService;
import com.testinium.bookstore.services.CategoryService;
import com.testinium.bookstore.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitListiener implements ApplicationListener<ContextRefreshedEvent>
{

    @Autowired
    BookStoreService bookStoreService;
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CityService cityService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        City city1 = new City(1,"Ankara",1.5);
        City city2 = new City(2,"İstanbul",1.2);
        City city3 = new City(3,"Eskişehir",1.6);

        cityService.save(city1);
        cityService.save(city2);
        cityService.save(city3);

        Category category1 = new Category(1,"Fantastic");
        Category category2 = new Category(2,"Horror");

        categoryService.save(category1);
        categoryService.save(category2);

        BookStore bookStore1 = new BookStore(1,"Ankara Merkez Kütüphanesi",city1);
        BookStore bookStore2 = new BookStore(2,"Kızılay İlçe Halk Kütüphanesi",city1);
        BookStore bookStore3 = new BookStore(3,"Eskişehir Halk Kütüphanesi",city3);
        BookStore bookStore4 = new BookStore(4,"İstanbul Halk Kütüphanesi",city2);

        bookStoreService.save(bookStore1);
        bookStoreService.save(bookStore2);
        bookStoreService.save(bookStore3);
        bookStoreService.save(bookStore4);

        List<BookStore> bookStores = new ArrayList<>();
        bookStores.add(bookStore1);
        bookStores.add(bookStore3);

        Book book1 = new Book(1,"Harry Potter ve Melez Prens",category1,bookStores,100);
        Book book2 = new Book(2,"Harry Potter ve Sırlar Odası",category1,bookStores,110);

        bookService.save(book1);
        bookService.save(book2);
    }
}
