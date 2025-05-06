package io.github.joaoVitorLeal.workshop_api.service;

import io.github.joaoVitorLeal.workshop_api.domain.User;
import io.github.joaoVitorLeal.workshop_api.dto.UserDto;
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

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update (User user) {
        User userToBeUpdated = repository.findById(user.getId())
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id " + user.getId()));
        updateData(userToBeUpdated, user);
        return repository.save(userToBeUpdated);
    }

    private void updateData(User userToBeUpdated, User user) {
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setEmail(user.getEmail());
    }

    public User toEntity(UserDto dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
