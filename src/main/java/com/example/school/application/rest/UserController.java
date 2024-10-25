package com.example.school.application.rest;

import com.example.school.domain.entity.User;
import com.example.school.domain.service.UserService;
import com.example.school.domain.to.UserTO;
import org.springframework.http.ResponseEntity;
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

}
