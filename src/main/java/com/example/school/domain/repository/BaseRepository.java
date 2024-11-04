package com.example.school.domain.repository;

import com.example.school.domain.exceptions.DomainException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository <T>{

  T save(T entity);

  List<T> findAll();

  T findById(UUID id) throws DomainException;

  T deleteById(UUID id) throws DomainException;

  boolean existsByEmail(String email) throws DomainException;

}
