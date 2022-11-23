package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.model.Role;

public interface RoleService {
    Role findByName(String name);

    Role save(Role role);
}