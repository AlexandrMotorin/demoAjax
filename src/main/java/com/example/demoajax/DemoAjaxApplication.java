package com.example.demoajax;

import com.example.demoajax.model.Person;
import com.example.demoajax.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoAjaxApplication {

    @Autowired
    private final PersonService personService;

    public DemoAjaxApplication(PersonService personService) {
        this.personService = personService;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoAjaxApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            Person sasha = Person.builder()
                    .name("Sasha")
                    .surname("Motorin")
                    .age(25)
                    .build();

            Person semen = Person.builder()
                    .name("Semen")
                    .surname("Slepakov")
                    .age(25)
                    .build();

            List.of(sasha, semen).forEach(personService::addPerson);
        };
    }
}
