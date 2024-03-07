package com.example.demo.jat.api;

import java.net.URI;

import com.example.demo.jat.dto.Person;
import com.example.demo.jat.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Person", description = "Person operations")
@RequestMapping("app/v1/person")
@RestController
public class PersonController implements PersonAPI {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Get a person by ID")
    @ApiResponse(responseCode = "200", description = "Person retrieved successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Person.class)))
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Person> get(@PathVariable int id) {
        return ResponseEntity.of(personService.get(id));
    }

    @Operation(summary = "Create a new person")
    @ApiResponse(responseCode = "201", description = "Person created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Person.class)))
    @PostMapping
    @Override
    public ResponseEntity<Person> create(@NonNull @RequestBody Person person) {
        URI location = UriComponentsBuilder.newInstance()
                .path("/app/v1/person/{id}")
                .buildAndExpand(person.getId())
                .toUri();
        return ResponseEntity.created(location).body(personService.create(person));
    }

    @Operation(summary = "Update an existing person by ID")
    @ApiResponse(responseCode = "200", description = "Person updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Person.class)))
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Person> update(@PathVariable int id, @NonNull @RequestBody Person person) {
        return ResponseEntity.of(personService.update(id, person));
    }

    @Operation(summary = "Delete a person by ID")
    @ApiResponse(responseCode = "204", description = "Person deleted successfully")
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable int id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
