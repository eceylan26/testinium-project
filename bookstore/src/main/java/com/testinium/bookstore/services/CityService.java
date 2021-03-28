package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    List<City> findAll();
    City findById(int id);
    City save (City city);
    void deleteById(int id);
    City updateById(int id,City city);
}
