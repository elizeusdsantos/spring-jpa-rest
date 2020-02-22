package com.monster.springjparest.service.impl;

import com.monster.springjparest.model.City;
import com.monster.springjparest.model.Country;
import com.monster.springjparest.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {

    @Mock
    CityRepository repository;
    @InjectMocks
    CityServiceImpl service;

    @Test
    void findAllByCountry() {
        String countryName = "Canada";
        Country canada = new Country("countryName");
        City toronto = new City("Toronto", canada);
        City vancouver = new City("Vancouver", canada);

        List<City> cities = new ArrayList<City>();
        cities.add(toronto);
        cities.add(vancouver);

        when(repository.findAllByCountry(countryName)).thenReturn(cities);
        List<City> returnedCities = repository.findAllByCountry(countryName);
        assertThat(returnedCities).hasSize(2);
    }

    @Test
    void saveUsingConstructors() {
        Country germany = new Country("Germany");
        City berlin = new City("Berlin", germany);

        when(repository.save(any(City.class))).thenReturn(berlin);

        City newCity = service.save(berlin);
        assertThat(newCity.getName()).isSameAs(berlin.getName());
    }

    @Test
    void saveUsingSets() {

        Country canada = new Country();
        canada.setId(1L);
        canada.setName("Canada");
        City vancouver = new City();
        vancouver.setId(1L);
        vancouver.setCountry(canada);
        vancouver.setName("Vancouver");

        when(repository.save(any(City.class))).thenReturn(vancouver);

        City newCity = service.save(vancouver);
        assertThat(newCity.getName()).isSameAs(vancouver.getName());
    }

}