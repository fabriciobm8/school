package com.example.school.application.rest;

import com.example.school.domain.entity.User;
import com.example.school.domain.service.UserService;
import com.example.school.domain.to.UserTO;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v1/user")
@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> create (@RequestBody UserTO userTO) {
    return ResponseEntity.ok(userService.createUser(userTO));
  }

  @GetMapping
  public List<User> getAll (){
    return userService.getUsers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

}
