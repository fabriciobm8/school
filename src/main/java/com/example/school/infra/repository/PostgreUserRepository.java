package com.example.school.infra.repository;

import com.example.school.domain.entity.User;
import com.example.school.domain.exceptions.DomainException;
import com.example.school.domain.exceptions.ErrorCode;
import com.example.school.domain.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  public Page<User> findAll(Pageable pageable){
    return userRepository.findAll(pageable);
  }

  @Override
  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public User findById(UUID id) throws DomainException {
    return userRepository.findById(id).orElseThrow(() -> new DomainException(ErrorCode.USER_NOT_FOUND));
  }

  @Override
  public User deleteById(UUID id) throws DomainException {
    User userToDelete = findById(id);
    userRepository.delete(userToDelete);
    return userToDelete;
  }

}
