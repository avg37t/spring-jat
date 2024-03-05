package com.example.demo.jat.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.example.demo.jat.dto.Person;
import com.example.demo.jat.service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonControllerTest {

    Map<Integer, Person> mockPersons;

    private PersonController personController;
    private static final String NAME = "John";
    private static final int AGE = 25;

    @Mock
    private Service service;

//    @BeforeEach
//    void setUp() {
//        personController = new PersonController(service);
//        mockPersons = new HashMap<>();
//        mockPersons.put(1, new Person(NAME, AGE));
//    }
//
//    @Test
//    void get_positive() {
//        Person person = new Person(NAME, AGE);
//        when(service.get(anyInt())).thenReturn(Optional.of(person));
//
//        ResponseEntity<Person> response = personController.get(1);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(person, response.getBody());
//    }
//
//    @Test
//    void get_not_found() {
//        when(service.get(anyInt())).thenReturn(Optional.empty());
//
//        ResponseEntity<Person> response = personController.get(1);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//    }
//
//    @Test
//    void create() {
//        Person person = new Person(NAME, AGE);
//        when(service.create(any())).thenReturn(person);
//
//        ResponseEntity<Person> response = personController.create(person);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(NAME, Objects.requireNonNull(response.getBody()).getName());
//        assertEquals(AGE, Objects.requireNonNull(response.getBody()).getAge());
//    }
//
//    @Test
//    void update() {
//        Person person = new Person(NAME, AGE);
////        when(service.update(anyInt(), any())).thenReturn(Optional.of(person));
////
////        ResponseEntity<Person> response = personController.update(1, person);
////
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals(NAME, Objects.requireNonNull(response.getBody()).getName());
////        assertEquals(AGE, Objects.requireNonNull(response.getBody()).getAge());
//    }
//
//    @Test
//    void delete() {
//        doNothing().when(service).delete(anyInt());
//
//        ResponseEntity<Person> response = personController.delete(1);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        verify(service).delete(anyInt());
//    }
}