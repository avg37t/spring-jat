package com.example.demo.jat.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.jat.dto.Person;
import com.example.demo.jat.repository.PersonRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
public class PersonPersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    public PersonPersonServiceImpl(final PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Person create(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Optional<Person> get(final int id) {
        return Optional.ofNullable(personRepo.findById(id));
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Optional<Person> update(final int id, final Person person) {
        var personOld = personRepo.findById(id);
        personOld.updateField(person);
        return Optional.ofNullable(personRepo.save(personOld));
    }

    @Override
    public void delete(final int id) {
        personRepo.deleteById((long) id);
    }
}
