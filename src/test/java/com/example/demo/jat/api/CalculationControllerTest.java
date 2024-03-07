package com.example.demo.jat.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.jat.dto.Person;
import com.example.demo.jat.service.PersonMathServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class CalculationControllerTest {

    @Mock
    private PersonMathServiceImpl personMathService;

    private CalculationController calculationController;

    private List<Person> persons;

    @BeforeEach
    void setUp() {
        calculationController = new CalculationController(personMathService);
        persons = new ArrayList<>(Arrays.asList(
                new Person(1, "First", 30),
                new Person(2, "Second", 28),
                new Person(3, "Third", 15)));
    }

    @Test
    void countPersonsNameStartsWithLetter() {
        when(personMathService.countPersonsNameStartsWithLetter( 'S', persons)).thenReturn(1L);

        var response = calculationController.countPersonsNameStartsWithLetter('S', persons);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody());
    }

    @Test
    void calculateAverageAge() {
        when(personMathService.calculateAverageAge(persons)).thenReturn("0.00");

        var response = calculationController.calculateAverageAge(persons);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("0.00", response.getBody());
    }

    @Test
    void findMissingIds() {
        var set = Set.of(1L,2L,3L);
        when(personMathService.findMissingIds(persons)).thenReturn(set);

        var response = calculationController.findMissingIds(persons);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(set, response.getBody());
    }
}