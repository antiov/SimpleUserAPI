package dev.antval.SimpleUserAPI.repository;

import dev.antval.SimpleUserAPI.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private static List<Person> allPeople = new ArrayList<>(
            Arrays.asList(
                    new Person(1L,"Luis","Valerio",32),
                    new Person(2L,"Joel","Sebastian",40),
                    new Person(3L,"Rubén","Quintero",35),
                    new Person(4L,"Francisco","Ortuño",35),
                    new Person(5L,"Irving","Moreno",35),
                    new Person(6L,"Arturo","Ramirez",35),
                    new Person(7L,"Arturo","Sánchez",35),
                    new Person(8L,"Miguel","Daniel",35)
            ));
    public Optional<Person> getById(Long id){
        return allPeople.stream().filter(p->p.getId().equals(id)).findFirst();
    }

    public List<Person> getAll(){return allPeople;}
}
