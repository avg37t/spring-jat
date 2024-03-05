package com.example.demo.jat.api;

import java.net.URI;

import com.example.demo.jat.dto.Person;
import com.example.demo.jat.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RestController
@RequestMapping("app/v1/person")
public class PersonController implements PersonAPI {

    private final Service service;

    @Override
    public ResponseEntity<Person> get(@PathVariable final int id) {
        return ResponseEntity.of(service.get(id));
    }

    @Override
    public ResponseEntity<Person> create(@NonNull final Person person) {
        URI location = UriComponentsBuilder.newInstance()
                .path("app/v1/person")
                .buildAndExpand(person)
                .toUri();
        return ResponseEntity.created(location).body(service.create(person));
    }

    @Override
    public ResponseEntity<Person> update(final int id, @NonNull final Person person) {
        return ResponseEntity.ok(service.update(id, person));
    }

    @Override
    public ResponseEntity<Person> delete(final int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//TODO resilence 4 (limits)
    }
}
