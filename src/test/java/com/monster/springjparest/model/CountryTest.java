package com.monster.springjparest.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountryTest {

    @Test
    public void StubTestForFields() {
        Country country = new Country();
        country.setId(1L);
        country.setName("Czech");

        assertThat(country.getId()).isEqualTo(1L);
        assertThat(country.getName()).isEqualTo("Czech");
    }
}