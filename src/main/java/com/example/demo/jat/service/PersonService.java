package com.example.demo.jat.service;

import java.util.Optional;

import com.example.demo.jat.dto.Person;
import com.example.demo.jat.repository.PersonRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class PersonService implements Service {

    private final PersonRepo personRepo;

    @Override
    public Person create(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Optional<Person> get(final int id) {
        return Optional.ofNullable(personRepo.findById(id));
    }

    @Override
    public Person update(final int id, Person person) {
        Person personOld = personRepo.findById(id);
        if (person.getName() != null) {
            personOld.setName(person.getName());
        }
        if (person.getAge() >= 0) {
            personOld.setAge(person.getAge());
        }
        return personRepo.save(personOld);
    }

    @Override
    public void delete(final int id) {
        personRepo.deleteById((long) id);
    }
}
