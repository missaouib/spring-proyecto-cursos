package com.fisi.proyectocursos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;
	
	@OneToMany(
			mappedBy = "categoria",
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
			fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Curso> cursos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
