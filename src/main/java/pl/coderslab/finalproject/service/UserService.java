package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.User;
import pl.coderslab.finalproject.model.dto.RegisterDto;

import java.util.List;

public interface UserService {

    User save(User u);

    User saveAdmin(User u);

    List<User> findAll();

    User findByUsername(String username);

    User registerUser(RegisterDto dto);
}