package com.example.demo.controller.api;

import com.example.demo.domain.Brand;
import com.example.demo.service.BrandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BrandRESTControllerTest {

    @Mock
    private BrandService brandService;

    @InjectMocks
    private BrandRESTController brandRESTController;

    ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    private Brand brand;

    private UUID id;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(brandRESTController).build();
        id = UUID.randomUUID();
        brand = Brand.builder().id(id).name("Tom").build();
    }

    @Test
    void testGetAllBrands() throws Exception {
        when(brandService.getAllBrands()).thenReturn(List.of(brand));

        mockMvc.perform(get("/api/brands"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(id.toString()))
                .andExpect(jsonPath("$[0].name").value("Tom"));
    }

    @Test
    void testGetBrandById() throws Exception {
        when(brandService.findById(id)).thenReturn(brand);

        mockMvc.perform(get("/api/brands/{id}",id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Tom"));
    }

    @Test
    void testCreateBrand() throws Exception {
        when(brandService.save(any(Brand.class))).thenReturn(brand);

        mockMvc.perform(post("/api/brands/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brand)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Tom"));
    }

    @Test
    void testUpdateBrand() throws Exception {
        when(brandService.edit(brand)).thenReturn(brand);

        mockMvc.perform(post("/api/brands/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brand)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Tom"));
    }

    @Test
    void testDeleteBrand() throws Exception {
        doNothing().when(brandService).deleteById(id);

        mockMvc.perform(delete("/api/brands/{id}", id))
                .andExpect(status().isOk());

        verify(brandService).deleteById(id);
    }
}
