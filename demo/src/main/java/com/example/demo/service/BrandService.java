package com.example.demo.service;

import com.example.demo.domain.Brand;

import java.time.LocalDate;
import java.util.*;

import com.example.demo.exception.NoSuchEntityException;
import com.example.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

   public void save(Brand brand) {
        brandRepository.save(brand);
   }

   public void edit(Brand brand) {
    brandRepository.save(brand);
   }

   public Brand findById(UUID id){
       Optional<Brand> optionalBrand = brandRepository.findById(id);
       if(optionalBrand.isPresent()){
           return optionalBrand.get();
       } else {
           throw new NoSuchEntityException("There was no brand with an identifier: " + id);
       }
   }

   public void deleteById(UUID id) {
        brandRepository.deleteById(id);
   }
}
