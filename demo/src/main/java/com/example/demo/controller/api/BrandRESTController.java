package com.example.demo.controller.api;

import com.example.demo.domain.Brand;
import com.example.demo.service.BrandService;
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
@RequestMapping("api/brands")
public class BrandRESTController {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable UUID id) {
        return brandService.findById(id);
    }

    @PostMapping("/create")
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.save(brand);
    }

    @PostMapping("/update")
    public Brand updateBrand(@RequestBody Brand brand) {
        return brandService.edit(brand);
    }

    @DeleteMapping("{id}")
    public void deleteBrand(@PathVariable UUID id) {
        brandService.deleteById(id);
    }
}
