package dev.antval.SimpleUserAPI.service;

import dev.antval.SimpleUserAPI.model.User;
import dev.antval.SimpleUserAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getById(Integer id){return userRepository.getById(id);}

    public List<User> getAll(){return userRepository.getAll();}
    public List<User> get(int page, int size){return userRepository.get(page,size);}
    public List<User> search(String position, String seniority){return userRepository.search(position,seniority);}
}
