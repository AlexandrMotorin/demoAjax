package com.example.demoajax.controllers;

import com.example.demoajax.model.Person;
import com.example.demoajax.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final PersonService personService;

    @Autowired
    public MyRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personService.findAll();
    }
}
