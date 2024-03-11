package com.example.demo.jat.service;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.example.demo.jat.dto.Person;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonMathServiceImpl implements PersonMathService {

    private static final String DECIMAL_FORMATTER = "#0.00";

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
    public String calculateAverageAge(final Collection<Person> persons) {
        var averageAge = Optional.ofNullable(persons)
                .map(collection -> collection.stream()
                        .filter(Objects::nonNull)
                        .mapToInt(Person::getAge)
                        .average()
                        .orElse(0.0))
                .orElse(0.0);
        DecimalFormat df = new DecimalFormat(DECIMAL_FORMATTER);
        return df.format(averageAge);
    }

    public Set<Long> findMissingIds(final Collection<Person> persons) {
        SortedSet<Long> existingIds = Optional.ofNullable(persons)
                .map(collection -> collection.stream()
                        .filter(Objects::nonNull)
                        .map(Person::getId)
                        .collect(Collectors.toCollection(TreeSet::new)))
                .orElse(new TreeSet<>());

        long startRange = existingIds.first();
        long endRange = existingIds.last();

        Set<Long> allIdsInRange = LongStream.rangeClosed(startRange, endRange)
                .boxed()
                .collect(Collectors.toSet());

        allIdsInRange.removeAll(existingIds);

        return allIdsInRange;
        //TODO security
    }
}
