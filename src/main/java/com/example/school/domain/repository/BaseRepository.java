package com.example.school.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository <T>{
  T save(T entity);

  List<T> findAll();

  Optional<T> findById(UUID id);

}
