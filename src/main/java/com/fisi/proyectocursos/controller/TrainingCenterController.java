package com.fisi.proyectocursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fisi.proyectocursos.model.TrainingCenter;
import com.fisi.proyectocursos.service.interfaces.ICourseService;
import com.fisi.proyectocursos.service.interfaces.ITrainingCenterService;
import com.fisi.proyectocursos.service.interfaces.IUserService;

@Controller
public class TrainingCenterController {
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ITrainingCenterService tcService;
	
	@GetMapping("/catalogo")
	public String catalogo(Model model, Authentication authentication) {
		String username = authentication.getName();
		TrainingCenter tc = tcService.findByUsername(username);
		
		model.addAttribute("cursos", courseService.findByTrainingCenter(tc));
		
 		return "catalogo";
	}
	
	@GetMapping("/catalogo/eliminar/{id}")
	public String eliminarCurso(Model model, @PathVariable Integer id) {
		
		return null;
	}


}
