package io.github.joaoVitorLeal.workshop_api.controller;

import io.github.joaoVitorLeal.workshop_api.domain.User;
import io.github.joaoVitorLeal.workshop_api.dto.UserDto;
import io.github.joaoVitorLeal.workshop_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable  String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto dto) {
        User user = service.toEntity(dto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
