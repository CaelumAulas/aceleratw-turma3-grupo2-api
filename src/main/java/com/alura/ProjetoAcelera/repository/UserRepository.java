package com.alura.ProjetoAcelera.repository;

import com.alura.ProjetoAcelera.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findByName(String name, Pageable pages);

	Optional<User> findByName(String name);
}
