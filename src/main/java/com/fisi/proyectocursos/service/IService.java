package com.fisi.proyectocursos.service;

import java.util.List;

public interface IService<T> {
	
	T save(T t);
	void deleteById(int id);
	List<T> findAll();
	T findById(int id);

}
