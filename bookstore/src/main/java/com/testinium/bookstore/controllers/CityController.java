package com.testinium.bookstore.controllers;

import com.testinium.bookstore.entities.Book;
import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.entities.City;
import com.testinium.bookstore.services.CategoryService;
import com.testinium.bookstore.services.CityService;
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
@Api(value = "City Api Documentation")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    @ApiOperation("Display all city")
    public ResponseEntity<List<City>> getAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/city/id/{id}")
    @ApiOperation("Display City by ID")
    public City getById(@PathVariable int id) throws NotFoundException {
        return cityService.findById(id);
    }

    @PostMapping("/city")
    @ApiOperation("Add Book")
    public ResponseEntity<Object> addBook(@RequestBody City city) {

        cityService.save(city);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(city.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/city/{id}")
    @ApiOperation("Update City by ID")
    public ResponseEntity<Object> updateCategory(@PathVariable int id,@RequestBody City city) {

        cityService.updateById(id,city);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(city.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/city/id/{id}")
    @ApiOperation("Delete Category")
    public void deleteCity(@PathVariable int id) {
        cityService.deleteById(id);
    }

}
