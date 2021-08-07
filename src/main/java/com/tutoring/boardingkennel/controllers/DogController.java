package com.tutoring.boardingkennel.controllers;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.services.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DogController {

    @Autowired
    DogServiceImpl dogService;

    @PostMapping(path = "/addDog", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Dog> addDog(@Valid @RequestBody Dog dog) {
        dogService.save(dog);
        return new ResponseEntity(dog, HttpStatus.CREATED);
    }

    @PostMapping(path = "/checkOutDog", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Dog>> checkOutDog(@Valid @RequestBody Dog dog) {
        dogService.delete(dog);
        List<Dog> remainingDogs = dogService.getAllDogs();
        return new ResponseEntity(remainingDogs, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
