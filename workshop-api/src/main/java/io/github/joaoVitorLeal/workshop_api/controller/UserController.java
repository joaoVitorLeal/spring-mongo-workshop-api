package io.github.joaoVitorLeal.workshop_api.controller;

import io.github.joaoVitorLeal.workshop_api.domain.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria98@gmail.com");
        User alex = new User("2", "Alex Green", "alex@outlook.com");

        List<User> users = new ArrayList<>(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(users);
    }
}
