package io.github.joaoVitorLeal.workshop_api.controller;

import io.github.joaoVitorLeal.workshop_api.domain.User;
import io.github.joaoVitorLeal.workshop_api.dto.UserDto;
import io.github.joaoVitorLeal.workshop_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(UserDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }
}
