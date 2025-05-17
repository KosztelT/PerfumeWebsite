package com.example.demo.service;

import com.example.demo.domain.Perfume;
import com.example.demo.exception.NoSuchEntityException;
import com.example.demo.repository.PerfumeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PerfumeServiceTest {

    @Mock
    private PerfumeRepository perfumeRepositoryMock;

    @InjectMocks
    private PerfumeService underTest;

    @Test
    void getAllPerfumes() {
        //GIVEN
        List<Perfume> expectedPerfumes = List.of(
                Perfume.builder()
                        .id(UUID.randomUUID())
                        .title("Elso parfum")
                        .releaseDate(LocalDate.now())
                        .build(),
                Perfume.builder()
                        .id(UUID.randomUUID())
                        .title("Masodik parfum")
                        .releaseDate(LocalDate.now())
                        .build()
        );
        when(perfumeRepositoryMock.findAll()).thenReturn(expectedPerfumes);
        //WHEN
        List<Perfume> result = underTest.getAllPerfumes();
        //THEN
        assertEquals(expectedPerfumes, result);
    }

    @Test
    void saveHappyPat() {
        //GIVEN
        Perfume expectedPerfume = Perfume.builder()
                .id(UUID.randomUUID())
                .releaseDate(LocalDate.now())
                .title("Elso parfum")
                .build();
        when(perfumeRepositoryMock.save(expectedPerfume)).thenReturn(expectedPerfume);
        //WHEN
        Perfume result = underTest.save(expectedPerfume);
        //THEN
        assertEquals(expectedPerfume, result);
    }

    @Test
    void editHappyPat() {
        //GIVEN
        Perfume expectedPerfume = Perfume.builder()
                .id(UUID.randomUUID())
                .releaseDate(LocalDate.now())
                .title("Elso parfum")
                .build();
        when(perfumeRepositoryMock.save(expectedPerfume)).thenReturn(expectedPerfume);
        //WHEN
        Perfume result = underTest.save(expectedPerfume);
        //THEN
        assertEquals(expectedPerfume, result);
    }

    @Test
    void findByIdWhenPerfumeFound() {
        //GIVEN
        UUID id = UUID.randomUUID();
        Perfume expectedPerfume = Perfume.builder()
                .id(id)
                .title("title1")
                .releaseDate(LocalDate.now())
                .build();
        Optional<Perfume> expectedPerfumeOptional = Optional.of(expectedPerfume);

        when(perfumeRepositoryMock.findById(id)).thenReturn(expectedPerfumeOptional);
        //WHEN
        Perfume result = underTest.findById(id);
        //THEN
        assertEquals(expectedPerfume, result);
    }

    /*
    @Test
    void findByIdWhenPerfumeMissing() {
        //GIVEN
        UUID id = UUID.randomUUID();
        String exceptionMessage = "There was no perfume with an identifier: " + id;

        Optional<Perfume> expectedPerfumeOptional = Optional.empty();

        when(perfumeRepositoryMock.findById(id)).thenReturn(expectedPerfumeOptional);
        //WHEN
        Exception exception =
                assertThrows(NoSuchEntityException.class, () -> underTest.findById(id));
        //THEN
        assertEquals(exceptionMessage, exception.getMessage());

    }
     */

    @Test
    void deleteByIDHappyPath() {
        //GIVEN
        UUID id = UUID.randomUUID();
        //WHEN
        underTest.deleteById(id);
        //THEN
        verify(perfumeRepositoryMock).deleteById(id);
    }

}
