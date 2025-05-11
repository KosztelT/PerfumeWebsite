package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Brand {
    private String name;
    private LocalDate founded;
}
