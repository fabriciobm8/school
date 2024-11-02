package com.example.school.domain.service;

import com.example.school.domain.entity.User;
import com.example.school.domain.exceptions.DomainException;
import com.example.school.domain.repository.UserRepository;
import com.example.school.domain.to.UserTO;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  public Page<User> getUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  public User getUserById(UUID id) throws DomainException{
    return userRepository.findById(id);
  }

  public User deleteUserById(UUID id) throws DomainException {
    return userRepository.deleteById(id);
  }

  public User updateUser (UserTO userTO, UUID id) throws DomainException{
    User user = this.getUserById(id);

    user.setName(userTO.getName());
    user.setEmail(userTO.getEmail());
    user.setPhone(userTO.getPhone());
    user.setRole(userTO.getRole());
    return userRepository.save(user);
  }
}
