package com.example.demo.service;

import com.example.demo.domain.Brand;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    public List<Brand> getAllBrands() {
        return brands;
    }

    private List<Brand> brands = List.of(
            Brand.builder()
                    .name("Brand1")
                    .dateOfFounded(LocalDate.of(1965, 10, 10))
                    .build(),
            Brand.builder()
                    .name("Brand2")
                    .dateOfFounded(LocalDate.of(1977, 5, 5))
                    .build(),
            Brand.builder()
                    .name("Brand3")
                    .dateOfFounded(LocalDate.of(1975, 1, 1))
                    .build()
    );
}
