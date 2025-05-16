package com.example.demo.controller.api;

import com.example.demo.domain.Perfume;
import com.example.demo.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/perfumes")
public class PerfumeRESTController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping()
    public List<Perfume> getAllPerfumes() { return perfumeService.getAllPerfumes(); }

    @GetMapping("{id}")
    public Perfume getPerfumeById(@PathVariable UUID id) {
        return perfumeService.findById(id);
    }

    @PostMapping("/create")
    public Perfume createPerfume(@RequestBody Perfume perfume) {
        return perfumeService.save(perfume);
    }

    @PostMapping("/update")
    public Perfume updatePerfume(@RequestBody Perfume perfume) {
        return perfumeService.edit(perfume);
    }

    @DeleteMapping("{id}")
    public void deletePerfumeById(@PathVariable UUID id) {
        perfumeService.deleteById(id);
    }
}
