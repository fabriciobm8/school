package com.example.school.infra.repository;

import com.example.school.domain.entity.User;
import com.example.school.domain.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PostgreUserRepository implements UserRepository {
  private final SpringDataUserRepository userRepository;

  public PostgreUserRepository(SpringDataUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User entity) {

    return userRepository.save(entity);
  }

  @Override
  public List<User> findAll(){
    return userRepository.findAll();
  }

  @Override
  public Optional<User> findById(UUID id) {
    return userRepository.findById(id);
  }

}
