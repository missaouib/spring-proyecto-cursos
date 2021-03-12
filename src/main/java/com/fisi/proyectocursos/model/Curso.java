package com.fisi.proyectocursos.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "fecha_inicio", columnDefinition = "DATE", nullable = false)
	private LocalDate fechaInicio;

	@Column(name = "duracion", nullable = false)
	private Integer duracion;

	@Column(name = "horario", nullable = false)
	private String horario;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "id_centro_capacitacion", nullable = false)
	private CentroCapacitacion centroCapacitacion;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "curso_etiqueta", 
			joinColumns = @JoinColumn(name = "curso_id", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "etiqueta_id", nullable = false))
	private List<Etiqueta> etiquetas;

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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CentroCapacitacion getCentroCapacitacion() {
		return centroCapacitacion;
	}

	public void setCentroCapacitacion(CentroCapacitacion centroCapacitacion) {
		this.centroCapacitacion = centroCapacitacion;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

}
