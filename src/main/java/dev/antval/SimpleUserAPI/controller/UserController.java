package dev.antval.SimpleUserAPI.controller;

import dev.antval.SimpleUserAPI.model.User;
import dev.antval.SimpleUserAPI.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService personService){
        this.userService = personService;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id){
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll(){return userService.getAll();}

    @QueryMapping
    Iterable<User> getUsers(@Argument int page, @Argument int size){
        return userService.get(page,size);
    }
    @QueryMapping
    User getById(@Argument int id){
        return userService.getById(id);
    }
    @QueryMapping
    Iterable<User> searchUsers(@Argument String position,@Argument String seniority){
        return userService.search(position,seniority);
    }
}
