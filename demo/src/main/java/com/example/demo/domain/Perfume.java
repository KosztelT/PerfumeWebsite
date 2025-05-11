package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Perfume {
    private String title;
    private LocalDate releaseDate;
    private Brand brand;

}
