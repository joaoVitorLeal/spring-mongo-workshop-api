package io.github.joaoVitorLeal.workshop_api.service;

import io.github.joaoVitorLeal.workshop_api.domain.User;
import io.github.joaoVitorLeal.workshop_api.exception.ObjectNotFoundException;
import io.github.joaoVitorLeal.workshop_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
       return repository.findById(id)
               .orElseThrow(() -> new ObjectNotFoundException("User not found with id " + id));
    }

    public void save(User user) {
        repository.save(user);
    }

    public void delete(User user) {
        repository.delete(user);
    }
}
