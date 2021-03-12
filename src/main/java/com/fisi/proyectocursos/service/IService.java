package com.fisi.proyectocursos.service;

import java.util.List;

public interface IService<T> {
	
	T registrar(T t);
	T modificar(T t);
	void eliminarPorId(int id);
	List<T> listar();
	T buscarPorId(int id);

}
