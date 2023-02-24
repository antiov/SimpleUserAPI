package dev.antval.SimpleUserAPI.repository;

import com.github.javafaker.Faker;
import dev.antval.SimpleUserAPI.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class UserRepository {
    private static List<User> allUsers;

    static{
        Faker faker = new Faker();
        allUsers =  IntStream.rangeClosed(1,300)
                .mapToObj( i -> new User(i,
                        faker.name().name(),
                        faker.name().lastName(),
                        faker.number().numberBetween(18,59),
                        faker.job().position(),
                        faker.job().seniority()))
                .collect(Collectors.toList());
    }
    public User getById(Integer id){
        return allUsers.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }

    public List<User> getAll(){return allUsers;}

    public List<User> get(int page, int size){
        List<User> res = new ArrayList<>();
        if((page-1)*size< allUsers.size())
            return allUsers.stream()
                    .skip((long) size*(page-1))
                    .limit(size)
                    .collect(Collectors.toList());
        return res;
    }

    public List<User> search(String position, String seniority){
        return allUsers.stream()
                .filter(u -> u.getPosition().equals(position)&&u.getSeniority().equals(seniority))
                .collect(Collectors.toList());
    }
}
