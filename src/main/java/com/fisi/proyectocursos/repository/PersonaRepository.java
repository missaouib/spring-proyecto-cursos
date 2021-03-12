package com.fisi.proyectocursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisi.proyectocursos.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
