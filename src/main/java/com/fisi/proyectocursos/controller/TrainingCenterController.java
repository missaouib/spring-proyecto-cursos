package com.fisi.proyectocursos.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fisi.proyectocursos.dto.CourseDto;
import com.fisi.proyectocursos.dto.converter.CourseDtoConverter;
import com.fisi.proyectocursos.model.Course;
import com.fisi.proyectocursos.model.TrainingCenter;
import com.fisi.proyectocursos.service.interfaces.ICourseService;
import com.fisi.proyectocursos.service.interfaces.ITrainingCenterService;

@Controller
public class TrainingCenterController {
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private ITrainingCenterService tcService;
	
	 @Autowired
	 private CourseDtoConverter converter;
	
	@ModelAttribute("newCourse")
	public CourseDto newCourse() {
		return new CourseDto();
	}
	
	@ModelAttribute("editCourse")
	public CourseDto editCourse() {
		return new CourseDto();
	}
	
	@ModelAttribute("id")
	public Integer id() {
		return -1;
	}
	
	@GetMapping("/catalogo")
	public String catalogo(Model model, Authentication authentication) {
		String username = authentication.getName();
		TrainingCenter tc = tcService.findByUsername(username);
		
		model.addAttribute("courses", courseService.findByTrainingCenter(tc));
		
 		return "catalogo";
	}
	
	@GetMapping("/catalogo/nuevo")
	public String nuevoCurso() {
		return "catalogo_nuevo";
	}
	
	@PostMapping("/catalogo/nuevo")
	public String nuevoCurso(CourseDto newCourse, Authentication authentication) {
		Course course = converter.courseDtoToCourse(newCourse);
		
		String username = authentication.getName();
		TrainingCenter tc = tcService.findByUsername(username);
		
		course.setTrainingCenter(tc);
		courseService.save(course);
		
		return "redirect:/catalogo";
	}
	
	@GetMapping("/catalogo/editar/{id}")
	public String editarCurso(Model model, @PathVariable Integer id) {
		Course course = courseService.findById(id);
		model.addAttribute("id", id);
		
		System.out.println(course.getName());
		
		return "catalogo_editar";
	}
	
	@PostMapping("/catalogo/editar")
	public String editarCurso(Model model, CourseDto editCourse, Authentication authentication) {
		System.out.println(editCourse.getId());
		Course course = courseService.findById(editCourse.getId());
		
//		System.out.println(course.getName());
		
//		String username = authentication.getName();
//		TrainingCenter tc = tcService.findByUsername(username);
		
//		course.setId(editCourse.getId());
//		course.setName(editCourse.getName());
//		course.setStartDate( LocalDate.parse(editCourse.getStartDate()) );
//		course.setDuration(editCourse.getDuration());
//		course.setSchedule(editCourse.getSchedule());
//		course.setStatus(editCourse.getStatus());
//		course.setUrl(editCourse.getUrl());
//		course.setTrainingCenter(tc);
//		
//		courseService.save(course);
		
		return "redirect:/catalogo";
	}

	@GetMapping("/catalogo/eliminar/{id}")
	public String eliminarCurso(@PathVariable Integer id) {
		courseService.deleteById(id);
		return "redirect:/catalogo";
	}
}
