package pl.coderslab.springbootexample.service;


import pl.coderslab.springbootexample.model.Role;

public interface RoleService {
    Role findByName(String name);
    Role save(Role role);
}
