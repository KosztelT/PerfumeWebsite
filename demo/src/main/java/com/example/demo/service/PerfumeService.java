package com.example.demo.service;

import com.example.demo.domain.Perfume;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.exception.NoSuchEntityException;
import com.example.demo.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    public List<Perfume> getAllPerfumes() {
        return perfumeRepository.findAll();
    }

    public Perfume save(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public Perfume edit(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public Perfume findById(UUID id) {
        Optional<Perfume> optionalPerfume = perfumeRepository.findById(id);
        if (optionalPerfume.isPresent()) {
            return optionalPerfume.get();
        } else {
            throw new NoSuchEntityException(
                    "There was no perfume with an identifier"
            );
        }
    }

    public void deleteById(UUID id) {
        perfumeRepository.deleteById(id);
    }
}
