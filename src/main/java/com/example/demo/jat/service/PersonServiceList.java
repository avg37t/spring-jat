package com.example.demo.jat.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.demo.jat.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceList implements PersonService {
    private final List<Person> persons;

    @Autowired
    public PersonServiceList() {
        persons = new ArrayList<>(Arrays.asList(
                new Person(1, "First", 30),
                new Person(2, "Second", 28),
                new Person(3, "Third", 15)));
    }

    @Override
    public Person create(Person person) {
        if(persons.stream().map(Person::getId).anyMatch(pId -> Objects.equals(pId, person.getId()))) {
            throw new IllegalArgumentException();
        }
        persons.add(person);
        return person;
    }

    @Override
    public void delete(int id) {
        Person p = get(id)
                .orElseThrow(IllegalArgumentException::new);
        if(!persons.remove(p)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public Optional<Person> get(int id) {
        return persons.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Person> update(int id, Person personInput) {
        Optional<Person> p = get(Math.toIntExact(personInput.getId()));
        p.ifPresent(person -> person.setName(personInput.getName()));
        return p;
    }
}
