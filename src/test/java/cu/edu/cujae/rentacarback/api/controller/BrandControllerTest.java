package cu.edu.cujae.rentacarback.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cu.edu.cujae.rentacarback.dto.BrandDTO;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static cu.edu.cujae.rentacarback.seeder.DataSets.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class BrandControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BrandRepository brandRepository;

    private final int getIndex = 0;
    private final int updateIndex = 1;
    private final int deleteIndex = 2;

    @BeforeEach
    void setup() {

    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/brand"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(brandRepository.findAll().size())))
                .andDo(print());
    }

    @Test
    void getById() throws Exception {
        int goodId = brandRepository.findAll().get(getIndex).getId();
        int badId = 0;
        mockMvc.perform(get("/brand/{id}", goodId))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.name", is(brands[getIndex].getName())))
                .andDo(print());
        mockMvc.perform(get("/brand/{id}", badId))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void createBrand() throws Exception{
        BrandDTO brand = new BrandDTO(null, "Kia");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(brand);

        mockMvc.perform(post("/brand")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void updateBrand() throws Exception {
        BrandDTO brand = new BrandDTO(brandRepository.findAll().get(updateIndex).getId(), "Lada");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(brand);

        mockMvc.perform(put("/brand/{id}", brand.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteBrand() throws Exception {
        mockMvc.perform(delete("/brand/{id}", brandRepository.findAll().get(deleteIndex)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}