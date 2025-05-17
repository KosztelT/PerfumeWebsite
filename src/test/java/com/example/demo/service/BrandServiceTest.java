package com.example.demo.service;

import com.example.demo.domain.Brand;
import com.example.demo.exception.NoSuchEntityException;
import com.example.demo.repository.BrandRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BrandServiceTest {

    @Mock
    private BrandRepository brandRepositoryMock;

    @InjectMocks
    private BrandService underTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBrandsHappyPath() {
        //GIVEN
        List<Brand> expectedBrands = List.of(
                Brand.builder()
                        .id(UUID.randomUUID())
                        .name("name1")
                        .dateOfFounded(LocalDate.now())
                        .build(),
                Brand.builder()
                        .id(UUID.randomUUID())
                        .name("name2")
                        .dateOfFounded(LocalDate.now())
                        .build()
        );

        when(brandRepositoryMock.findAll()).thenReturn(expectedBrands);
        //WHEN
        List<Brand> result = underTest.getAllBrands();

        //THEN
        Assertions.assertIterableEquals(expectedBrands, result);
    }

    @Test
    void findByIdWhenBrandFound() {
        //GIVEN
        UUID id = UUID.randomUUID();
        Brand expectedBrand = Brand.builder()
                .id(id)
                .name("name1")
                .dateOfFounded(LocalDate.now())
                .build();
        Optional<Brand> expectedBrandOptional = Optional.of(expectedBrand);

        when(brandRepositoryMock.findById(id)).thenReturn(expectedBrandOptional);
        //WHEN
        Brand result = underTest.findById(id);
        //THEN
        assertEquals(expectedBrand, result);
    }

    @Test
    void findByIdWhenBrandMissing() {
        //GIVEN
        UUID id = UUID.randomUUID();
        String exceptionMessage = "There was no brand with an identifier: " + id;

        Optional<Brand> expectedBrandOptional = Optional.empty();

        when(brandRepositoryMock.findById(id)).thenReturn(expectedBrandOptional);
        //WHEN
        Exception exception =
                assertThrows(NoSuchEntityException.class, () -> underTest.findById(id));
        //THEN
        assertEquals(exceptionMessage, exception.getMessage());

    }

    @Test
    void deleteByIDHappyPath() {
        //GIVEN
        UUID id = UUID.randomUUID();
        //WHEN
        underTest.deleteById(id);
        //THEN
        verify(brandRepositoryMock).deleteById(id);
    }

    @Test
    void saveHappyPath() {
        //GIVEN
        Brand expectedBrand = Brand.builder()
                .id(UUID.randomUUID())
                .name("Louis")
                .dateOfFounded(LocalDate.now())
                .build();

        when(brandRepositoryMock.save(expectedBrand)).thenReturn(expectedBrand);
        //WHEN
        Brand result = underTest.save(expectedBrand);
        //THEN
        assertEquals(expectedBrand, result);
    }

    @Test
    void editHappyPath() {
        //GIVEN
        Brand expectedBrand = Brand.builder()
                .id(UUID.randomUUID())
                .name("Louis")
                .dateOfFounded(LocalDate.now())
                .build();

        when(brandRepositoryMock.save(expectedBrand)).thenReturn(expectedBrand);
        //WHEN
        Brand result = underTest.save(expectedBrand);
        //THEN
        assertEquals(expectedBrand, result);
    }
}
