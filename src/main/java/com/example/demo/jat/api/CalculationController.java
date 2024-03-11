package com.example.demo.jat.api;

import com.example.demo.jat.dto.Person;
import com.example.demo.jat.service.PersonMathServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@Tag(name = "Calculation", description = "Person calculation operations")
@RequestMapping("app/v1/calculation")
@RestController
public class CalculationController {

    private final PersonMathServiceImpl personMathService;

    public CalculationController(PersonMathServiceImpl personMathService) {
        this.personMathService = personMathService;
    }

    @Operation(summary = "Count persons whose name starts with a specified letter")
    @ApiResponse(responseCode = "200", description = "Number of persons counted successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Long.class)))
    @PostMapping("/letter")
    public ResponseEntity<Long> countPersonsNameStartsWithLetter(
            @RequestParam char firstLetter,
            @RequestBody Collection<Person> persons) {
        return ResponseEntity.ok(personMathService.countPersonsNameStartsWithLetter(firstLetter, persons));
    }

    @Operation(summary = "Calculate the average age of persons")
    @ApiResponse(responseCode = "200", description = "Average age calculated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    @PostMapping
    public ResponseEntity<String> calculateAverageAge(
            @RequestBody Collection<Person> persons) {
        return ResponseEntity.ok(personMathService.calculateAverageAge(persons));
    }

    @Operation(summary = "Find missing IDs in the collection of persons")
    @ApiResponse(responseCode = "200", description = "Missing IDs found successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Set.class)))
    @PostMapping("/missing-ids")
    public ResponseEntity<Set<Long>> findMissingIds(
            @RequestBody Collection<Person> persons) {
        return ResponseEntity.ok(personMathService.findMissingIds(persons));
    }
}
