package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    @Column(name = "date_of_founded")
    private LocalDate dateOfFounded;
    @OneToMany(mappedBy = "brands", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Perfume> perfumes;
}
