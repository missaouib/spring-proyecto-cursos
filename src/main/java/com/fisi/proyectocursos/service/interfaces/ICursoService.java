package com.fisi.proyectocursos.service.interfaces;

import java.util.List;

import com.fisi.proyectocursos.model.CentroCapacitacion;
import com.fisi.proyectocursos.model.Curso;
import com.fisi.proyectocursos.service.IService;

public interface ICursoService extends IService<Curso> {
	
	List<Curso> listarPorCentroCapacitacion(CentroCapacitacion centroCapacitacion);

}
