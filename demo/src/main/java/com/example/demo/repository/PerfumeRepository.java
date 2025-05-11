package com.example.demo.repository;

import com.example.demo.domain.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerfumeRepository extends JpaRepository<Perfume, UUID> {
}
