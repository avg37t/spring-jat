package com.example.demo.jat.dto;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public Person(final long id, final String name, final int age) {
        this(name, age);
        this.id = id;
    }

    public void updateField(Person updatedPerson) {
        Class<?> clazz = getClass();
        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(field -> {
                    try {
                        return Objects.nonNull(field.get(updatedPerson));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        field.set(this, field.get(updatedPerson));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
