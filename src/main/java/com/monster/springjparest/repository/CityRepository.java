package com.monster.springjparest.repository;

import com.monster.springjparest.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "select ct.* from sample.city ct join sample.country cn on ct.country_id = cn.id " +
            "where cn.name = :country ", nativeQuery = true)
    List<City> findAllByCountry(String country);
}
