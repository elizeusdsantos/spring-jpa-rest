package com.monster.springjparest.service.impl;

import com.monster.springjparest.model.Country;
import com.monster.springjparest.repository.CountryRepository;
import com.monster.springjparest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Override
    public Country findById(Long id) {
        Optional<Country> country = repository.findById(id);
        if (country.isPresent()) {
            return country.get();
        } else {
            throw new EntityNotFoundException("There are no country with id " + id + " registered in the database.");
        }
    }
}
