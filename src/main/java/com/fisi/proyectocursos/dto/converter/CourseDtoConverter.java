package com.fisi.proyectocursos.dto.converter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fisi.proyectocursos.dto.CourseDto;
import com.fisi.proyectocursos.model.Course;

@Component
public class CourseDtoConverter {

	public Course courseDtoToCourse(CourseDto dto) {
		Course course = new Course();
		course.setId(dto.getId());
		course.setName(dto.getName());
		course.setStartDate( LocalDate.parse(dto.getStartDate()) );
		course.setDuration(dto.getDuration());
		course.setSchedule(dto.getSchedule());
		course.setStatus(dto.getStatus());
		course.setUrl(dto.getUrl());
		
		return course;
	}
	
	public CourseDto courseToCourseDto(Course course) {
		CourseDto dto = new CourseDto();
		dto.setId(course.getId());
		dto.setName(course.getName());
		dto.setStartDate(course.getStartDate().toString());
		dto.setDuration(course.getDuration());
		dto.setSchedule(course.getSchedule());
		dto.setStatus(course.getStatus());
		dto.setUrl(course.getUrl());
		
		return dto;
	}
	
}
