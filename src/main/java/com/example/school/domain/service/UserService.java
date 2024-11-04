package com.example.school.domain.service;

import com.example.school.domain.entity.User;
import com.example.school.domain.exceptions.DomainException;
import com.example.school.domain.exceptions.ErrorCode;
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

  private void validateUserData(UserTO userTO) throws DomainException {
    if (userTO.getName() == null || userTO.getEmail() == null || userTO.getRole() == null) {
      throw new DomainException("Campos obrigatórios não podem ser nulos", ErrorCode.INVALID_PARAMS);
    }
  }

  public User createUser(UserTO userTO) throws DomainException {
    validateUserData(userTO);
    User user = User.builder()
        .name(userTO.getName())
        .email(userTO.getEmail())
        .phone(userTO.getPhone())
        .role(userTO.getRole())
        .build();
    if (userRepository.existsByEmail(userTO.getEmail())){
      throw new DomainException("Email ja cadastrado", ErrorCode.EMAIL_EXISTENT);
    }
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
    validateUserData(userTO);
    User user = this.getUserById(id);
    if (!user.getEmail().equals(userTO.getEmail()) &&
        userRepository.existsByEmail(userTO.getEmail())) {
      throw new DomainException("Email já cadastrado", ErrorCode.EMAIL_EXISTENT);
    }

    user.setName(userTO.getName());
    user.setEmail(userTO.getEmail());
    user.setPhone(userTO.getPhone());
    user.setRole(userTO.getRole());
    return userRepository.save(user);
  }
}
