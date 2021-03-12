package com.fisi.proyectocursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisi.proyectocursos.model.CentroCapacitacion;
import com.fisi.proyectocursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	
	List<Curso> findByCentroCapacitacion(CentroCapacitacion centroCapacitacion);

}
