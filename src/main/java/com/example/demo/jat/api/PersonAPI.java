package com.example.demo.jat.api;

import com.example.demo.jat.dto.Person;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("app/v1/person")
public interface PersonAPI {

    @GetMapping("/{id}")
    ResponseEntity<Person> get(@PathVariable @Min(value = 0, message = "Number must be non-negative") int id);

    @PostMapping()
    ResponseEntity<Person> create(@RequestBody @NonNull Person person);

    @PutMapping("/{id}")
    ResponseEntity<Person> update(@PathVariable @Min(value = 0, message = "Number must be non-negative") int id, @RequestBody @NonNull Person person);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable @Min(value = 0, message = "Number must be non-negative") int id);
}
