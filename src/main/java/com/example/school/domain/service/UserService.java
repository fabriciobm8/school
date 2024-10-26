package com.example.school.domain.service;

import com.example.school.domain.entity.User;
import com.example.school.domain.repository.UserRepository;
import com.example.school.domain.to.UserTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(UserTO userTO) {
    User user = User.builder()
        .name(userTO.getName())
        .email(userTO.getEmail())
        .phone(userTO.getPhone())
        .role(userTO.getRole())
        .build();
    return userRepository.save(user);
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUserById(UUID id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found: " + id));
  }

}
