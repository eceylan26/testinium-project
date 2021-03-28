package com.testinium.bookstore.services;

import com.testinium.bookstore.entities.Category;
import com.testinium.bookstore.entities.City;
import com.testinium.bookstore.repositories.CategoryRepository;
import com.testinium.bookstore.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(int id) {
        return cityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City updateById(int id, City city) {
        City currentCity = cityRepository.getOne(id);

        currentCity.setName(city.getName());
        currentCity.setPriceFactor(city.getPriceFactor());
        cityRepository.save(currentCity);
        return currentCity;

    }
}
