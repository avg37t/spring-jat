package com.example.demo.jat.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.example.demo.jat.dto.Person;
import org.apache.commons.lang3.StringUtils;

public class PersonMathServiceImpl implements PersonMathService {

//    public static void main(String[] args) {
//        PersonMathServiceImpl obj = new PersonMathServiceImpl();
//        List<Person> peoples = List.of(
//                new Person(1L, "Alice", 25),
//                new Person(2L, "Bob", 30),
//                new Person(3L, "Charlie", 22),
//                new Person(4L, "David", 28),
//                new Person(5L, "Eve", 35),
//                new Person(7L, "Andrey", 35)
//                                      );
//
//        System.out.println(obj.findMissingIds(peoples));
//    }

    @Override
    public long countPersonsNameStartsWithLetter(final char firstLetter, final Collection<Person> persons) {
        return Optional.ofNullable(persons)
                .map(collection -> collection.stream()
                        .filter(Objects::nonNull)
                        .map(Person::getName)
                        .filter(StringUtils::isNotBlank)
                        .filter(name -> name.startsWith(String.valueOf(firstLetter)))
                        .count())
                .orElse(0L);
    }

    @Override
    public double calculateAverageAge(final Collection<Person> persons) {
        return Optional.ofNullable(persons)
                .map(collection -> collection.stream()
                        .filter(Objects::nonNull)
                        .mapToInt(Person::getAge)
                        .average()
                        .orElse(0.0))
                .orElse(0.0);
    }

    public Set<Long> findMissingIds(final Collection<Person> persons) {
        Set<Long> existingIds =
                Optional.ofNullable(persons)
                        .map(collection -> collection.stream()
                                .filter(Objects::nonNull)
                                .map(Person::getId)
                                .collect(Collectors.toSet()))
                        .orElse(Collections.emptySet());

        long startRange = 1;
        long endRange = 7;

        Set<Long> allIdsInRange = LongStream.rangeClosed(startRange, endRange)
                .boxed()
                .collect(Collectors.toSet());

        allIdsInRange.removeAll(existingIds);

        return allIdsInRange;
    }
}
