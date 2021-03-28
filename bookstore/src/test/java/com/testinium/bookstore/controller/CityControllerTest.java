package com.testinium.bookstore.controller;

import com.testinium.bookstore.controllers.CityController;
import com.testinium.bookstore.entities.City;
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
@WebMvcTest(CityController.class)
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService cityService;

    @Test
    void whenGetAllCities_thenReturnCities() throws Exception {

        City city = City.builder().name("Eskisehir").priceFactor(2).build();

        List<City> cities = Arrays.asList(city);

        Mockito.when(cityService.findAll()).thenReturn(cities);

        mockMvc.perform(get("/cities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is(city.getName())))
                .andExpect(jsonPath("$[0].priceFactor", Matchers.is(city.getPriceFactor())));

    }

}
