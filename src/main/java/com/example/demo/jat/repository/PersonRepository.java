package com.example.demo.jat.repository;

import java.util.Map;
import java.util.TreeMap;

import com.example.demo.jat.dto.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    private final Map<Integer, Person> peopleMap = new TreeMap<>();

//    {
//        peopleMap.put(1, new Person("John", "25"));
//        peopleMap.put(2, new Person("Alice", "30"));
//        peopleMap.put(3, new Person("Bob", "28"));
//        peopleMap.put(4, new Person("Eva", "22"));
//        peopleMap.put(5, new Person("Michael", "35"));
//    }

    public Map<Integer, Person> getPeopleMap() {
        return peopleMap;
    }
}
