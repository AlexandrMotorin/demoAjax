package com.example.demoajax.service;

import com.example.demoajax.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    void addPerson(Person person);
}
