package com.monster.springjparest.service;

import com.monster.springjparest.model.City;

import java.util.List;

public interface CityService {

    List<City> findAllByCountry(String country);

    City save(City city);
}
