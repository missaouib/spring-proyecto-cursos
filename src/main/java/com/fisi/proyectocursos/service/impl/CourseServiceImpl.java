package com.fisi.proyectocursos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisi.proyectocursos.model.Course;
import com.fisi.proyectocursos.model.TrainingCenter;
import com.fisi.proyectocursos.repository.CourseRepository;
import com.fisi.proyectocursos.service.interfaces.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteById(int id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findById(int id) {
		return courseRepository.findById(id).orElse(null);
	}

	@Override
	public List<Course> listarPorCentroCapacitacion(TrainingCenter trainingCenter) {
		return courseRepository.findByTrainingCenter(trainingCenter);
	}

	
	
}
