package dev.antval.SimpleUserAPI.controller;

import dev.antval.SimpleUserAPI.model.Person;
import dev.antval.SimpleUserAPI.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Optional<Person> get(@PathVariable("id") Long id){
        return personService.getById(id);
    }

    @GetMapping
    public List<Person> getAll(){return personService.getAll();}
}
