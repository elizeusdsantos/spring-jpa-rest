package com.monster.springjparest.controller.v1;

import com.monster.springjparest.DTO.CityDTO;
import com.monster.springjparest.model.City;
import com.monster.springjparest.model.Country;
import com.monster.springjparest.repository.CityRepository;
import com.monster.springjparest.service.CityService;
import com.monster.springjparest.service.impl.CityServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CityControllerTest {

    @Mock
    CityRepository repository;
    @Autowired
    private MockMvc mvc;

    @Test
    void retrieveCitiesFromExistentCountry() throws Exception {
        mvc.perform(get("/v1/cities?country=France")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":8,\"name\":\"Paris\",\"country\":{\"id\":3,\"name\":\"France\"}},{\"id\":9,\"name\":\"Lyon\",\"country\":{\"id\":3,\"name\":\"France\"}}]"));
    }

    @Test
    void retrieveCitiesFromNotExistentCountry() throws Exception {
        mvc.perform(get("/v1/cities?country=Xxx")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }

    @Test
    void testBadRequest() throws Exception {
        mvc.perform(get("/v1/cities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnAValidDTO() {

        CityService service = new CityServiceImpl(repository);
        CityController controller = new CityController(service, new ModelMapper());

        Country stubContry = new Country();
        stubContry.setId(666L);
        stubContry.setName("Brazil");

        City stubCity = new City("Petrolopis", stubContry);
        stubCity.setId(999L);

        when(service.save(any(City.class))).thenReturn(stubCity);

        CityDTO dto = controller.save(new City());
        assertThat(dto.getCountryId()).isEqualTo(stubContry.getId());
        assertThat(dto.getId()).isEqualTo(stubCity.getId());
        assertThat(dto.getName()).isEqualTo(stubCity.getName());
    }

}