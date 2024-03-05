package com.example.demo.jat.service;

import java.util.Optional;

import com.example.demo.jat.dto.Person;

public interface Service {

    Person create(Person person);

    Optional<Person> get(int id);

    Person update(int id, Person person);

    void delete(int id);
}
