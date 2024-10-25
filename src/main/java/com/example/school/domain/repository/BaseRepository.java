package com.example.school.domain.repository;

import java.util.List;

public interface BaseRepository <T>{
  T save(T entity);

  List<T> findAll();
}
