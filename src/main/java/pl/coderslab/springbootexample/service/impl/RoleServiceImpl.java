package pl.coderslab.springbootexample.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.springbootexample.model.Role;
import pl.coderslab.springbootexample.repository.RoleRepository;
import pl.coderslab.springbootexample.service.RoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {//implementujemy kontrakt dla serwisu roli
    // główne zalety to łatwiejsza możliwość testowania serwisów
    // późniejsze możliwości rozwoju dzięki przesłanianiu przez interfejs
    // (możemy stworzyć nowy serwis który działa inaczej - np laczy sie z innym kontenerem danych - a dla
    // reszty aplikacji jest to przezroczyste)
    // dodatkowo mamy zapewniona separacje miedzy warstwami aplikacji (clean architecture)

    private final RoleRepository repository;
    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }
}
