package com.example.demo.controller.api;

import com.example.demo.domain.Perfume;
import com.example.demo.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/perfumes")
public class PerfumeRESTController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping()
    public List<Perfume> getAllPerfumes() {
        return perfumeService.getAllPerfumes(); }

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
