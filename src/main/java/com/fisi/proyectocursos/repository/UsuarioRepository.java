package com.fisi.proyectocursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisi.proyectocursos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
