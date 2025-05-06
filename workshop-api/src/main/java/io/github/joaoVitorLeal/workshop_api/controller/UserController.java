package io.github.joaoVitorLeal.workshop_api.controller;

import io.github.joaoVitorLeal.workshop_api.domain.User;
import io.github.joaoVitorLeal.workshop_api.dto.UserResponseDto;
import io.github.joaoVitorLeal.workshop_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        BeanUtils.copyProperties(list, UserResponseDto.class);
        return ResponseEntity.ok().body(list);
    }
}
