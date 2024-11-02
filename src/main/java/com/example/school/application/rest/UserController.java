package com.example.school.application.rest;

import com.example.school.domain.entity.User;
import com.example.school.domain.exceptions.DomainException;
import com.example.school.domain.exceptions.ErrorCode;
import com.example.school.domain.service.UserService;
import com.example.school.domain.to.UserTO;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public ResponseEntity<User> create(@Valid @RequestBody UserTO userTO) throws DomainException {
    return ResponseEntity.ok(userService.createUser(userTO));
  }

  @GetMapping
  public List<User> getAll (){
    return userService.getUsers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable UUID id) throws DomainException {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String,String>> deleteUserById(@PathVariable UUID id) throws DomainException{
    userService.deleteUserById(id);
    Map<String, String> response = new HashMap<>();
    response.put("message", "User deleted successfully");
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@Valid @RequestBody UserTO userTO,
      @PathVariable("id") UUID id) throws DomainException {
    return ResponseEntity.ok(userService.updateUser(userTO, id));
  }

}
