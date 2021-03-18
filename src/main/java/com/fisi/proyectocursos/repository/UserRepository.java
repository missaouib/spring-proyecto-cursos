package com.fisi.proyectocursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisi.proyectocursos.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
	boolean existsByUsername(String username);

}
