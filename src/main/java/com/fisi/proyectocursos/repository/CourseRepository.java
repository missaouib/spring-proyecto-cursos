package com.fisi.proyectocursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisi.proyectocursos.model.Course;
import com.fisi.proyectocursos.model.TrainingCenter;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	List<Course> findByTrainingCenter(TrainingCenter trainingCenter);

}
