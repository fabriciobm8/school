package com.example.school.domain.repository;

public interface BaseRepository <T>{
  T save(T entity);
}
