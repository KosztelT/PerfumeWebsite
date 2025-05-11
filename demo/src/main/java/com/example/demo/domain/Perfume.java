package com.example.demo.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String title;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

}
