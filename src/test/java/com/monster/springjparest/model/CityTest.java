package com.monster.springjparest.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CityTest {

    @Test
    public void StubTestForFields() {
        City city = new City();
        Country brazil = new Country();
        city.setId(1L);
        city.setName("Seattle");
        city.setCountry(brazil);

        assertThat(city.getId()).isEqualTo(1L);
        assertThat(city.getName()).isEqualTo("Seattle");
        assertThat(city.getCountry()).isEqualTo(brazil);

        City city2 = new City("Porto Alegre", new Country("Brazil"));
        assertThat(city2.getName()).isEqualTo("Porto Alegre");
        assertThat(city2.getCountry().getName()).isEqualTo("Brazil");
    }
}