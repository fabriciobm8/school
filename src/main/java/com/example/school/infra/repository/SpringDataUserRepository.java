package com.example.school.infra.repository;

import com.example.school.domain.entity.User;
import java.util.Optional;
import java.util.UUID;
import javax.swing.text.html.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<User, UUID> {

}
