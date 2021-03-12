package com.fisi.proyectocursos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisi.proyectocursos.model.CentroCapacitacion;
import com.fisi.proyectocursos.model.Curso;
import com.fisi.proyectocursos.repository.CursoRepository;
import com.fisi.proyectocursos.service.interfaces.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public Curso registrar(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso modificar(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public void eliminarPorId(int id) {
		cursoRepository.deleteById(id);
	}

	@Override
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso buscarPorId(int id) {
		return cursoRepository.findById(id).get();
	}

	@Override
	public List<Curso> listarPorCentroCapacitacion(CentroCapacitacion centroCapacitacion) {
		return cursoRepository.findByCentroCapacitacion(centroCapacitacion);
	}

}
