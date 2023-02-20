package dev.antval.SimpleUserAPI.service;

import dev.antval.SimpleUserAPI.model.Person;
import dev.antval.SimpleUserAPI.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    public Optional<Person> getById(Long id){
        return personRepository.getById(id);
    }

    public List<Person> getAll(){return personRepository.getAll();}
}
