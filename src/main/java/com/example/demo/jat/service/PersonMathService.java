package com.example.demo.jat.service;

import java.util.Collection;
import java.util.Set;

import com.example.demo.jat.dto.Person;

public interface PersonMathService {

    long countPersonsNameStartsWithLetter(final char firstLetter, Collection<Person> persons);
    double calculateAverageAge(Collection<Person> persons);
    Set<Long> findMissingIds(Collection<Person> persons);
}
