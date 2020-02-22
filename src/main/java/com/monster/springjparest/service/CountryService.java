package com.monster.springjparest.service;

import com.monster.springjparest.model.Country;

public interface CountryService {

    Country save(Country country);

    Country findById(Long id);
}
