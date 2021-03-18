package com.fisi.proyectocursos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("C")
public class TrainingCenter extends User {

	@Column(name = "name") 
	private String name;

	@OneToMany(
			mappedBy = "trainingCenter", 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Course> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	

}
