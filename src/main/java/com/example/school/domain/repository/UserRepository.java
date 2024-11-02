package com.example.school.domain.repository;

import com.example.school.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository extends BaseRepository<User>{

  Page<User> findAll(Pageable pageable);

}
