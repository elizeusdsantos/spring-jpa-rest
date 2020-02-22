package com.monster.springjparest.controller.v1;

import com.monster.springjparest.DTO.CityDTO;
import com.monster.springjparest.model.City;
import com.monster.springjparest.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cities")
public class CityController {

    private CityService service;
    private ModelMapper mapper;

    public CityController(CityService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<City> find(@RequestParam String country) {

        return service.findAllByCountry(country);
    }

    @PostMapping
    public CityDTO save(@RequestBody City city) {
        City savedCity = service.save(city);
        return convertToDTO(savedCity);
    }

    private CityDTO convertToDTO(City city) {
        return mapper.map(city, CityDTO.class);
    }

}