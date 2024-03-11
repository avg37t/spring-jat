package com.example.demo.jat.repository;

import com.example.demo.jat.dto.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {

    Person findById(int id);

    Person save(Person person);
}
