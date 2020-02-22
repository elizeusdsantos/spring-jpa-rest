package com.monster.springjparest.service.impl;

import com.monster.springjparest.model.City;
import com.monster.springjparest.repository.CityRepository;
import com.monster.springjparest.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> findAllByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    public City save(City city) {
        return repository.save(city);
    }
}
