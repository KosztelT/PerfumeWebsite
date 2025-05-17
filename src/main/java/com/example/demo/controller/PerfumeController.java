package com.example.demo.controller;

import com.example.demo.domain.Perfume;
import com.example.demo.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("perfumes")
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping()
    public List<Perfume> getAllPerfumes() {
        return perfumeService.getAllPerfumes();
    }
}
