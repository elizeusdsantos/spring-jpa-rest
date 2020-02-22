package com.monster.springjparest.controller.v1;

import com.monster.springjparest.model.Country;
import com.monster.springjparest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/{id}")
    public Country findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @PostMapping
    public Country save(@RequestBody Country country) {

        return service.save(country);
    }

}