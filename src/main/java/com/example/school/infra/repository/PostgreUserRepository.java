package com.example.school.infra.repository;

import com.example.school.domain.entity.User;
import com.example.school.domain.repository.UserRepository;
import java.util.List;
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

}
