package pl.coderslab.springbootexample.service;


import pl.coderslab.springbootexample.model.User;
import pl.coderslab.springbootexample.model.dto.RegisterDto;

import java.util.List;

public interface UserService {

    User save(User u);
    User saveAdmin(User u);
    List<User> findAll();
    User findByUsername(String username);
    User registerUser(RegisterDto dto);
}
