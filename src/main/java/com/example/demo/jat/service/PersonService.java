package com.example.demo.jat.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.jat.dto.Person;

public interface PersonService {

    Person create(Person person);

    Optional<Person> get(int id);

    List<Person> getAll();

    Optional<Person> update(int id, Person person);

    void delete(int id);
}
