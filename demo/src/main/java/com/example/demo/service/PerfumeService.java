package com.example.demo.service;

import com.example.demo.domain.Brand;
import com.example.demo.domain.Perfume;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
public class PerfumeService {

    public List<Perfume> getAllPerfumes(){
        return perfumes;
    }

    private List<Perfume> perfumes = List.of(
            Perfume.builder()
                    .title("title1")
                    .releaseDate(LocalDate.of(2003, 4, 10))
                    .brand(
                            Brand.builder()
                                    .name("Brand1")
                                    .founded(LocalDate.of(1965, 10, 10))
                                    .build()
                    )
                    .build(),
            Perfume.builder()
                    .title("title2")
                    .releaseDate(LocalDate.of(2005, 2, 4))
                    .brand(
                            Brand.builder()
                                    .name("Brand2")
                                    .founded(LocalDate.of(1977, 5, 5))
                                    .build()
                    )
                    .build(),
            Perfume.builder()
                    .title("title3")
                    .releaseDate(LocalDate.of(1999, 3, 10))
                    .brand(
                            Brand.builder()
                                    .name("Brand3")
                                    .founded(LocalDate.of(1975, 1, 1))
                                    .build()
                    )
                    .build()
    );

}
