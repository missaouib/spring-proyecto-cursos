package com.fisi.proyectocursos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fisi.proyectocursos.model.CentroCapacitacion;
import com.fisi.proyectocursos.model.Curso;
import com.fisi.proyectocursos.service.interfaces.ICursoService;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private ICursoService cursoService;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute("cursos")
	public List<Curso> cursosCentroCapacitacion() {
		// CentroCapacitacion centroCapacitacion = (CentroCapacitacion) session.getAttribute("centroCapacitacion");
		CentroCapacitacion centroCapacitacion = new CentroCapacitacion();
		centroCapacitacion.setId(1);
		return cursoService.listarPorCentroCapacitacion(centroCapacitacion);
	}
	
	@GetMapping("/cursos")
	public String listar() {
		return "lista_cursos";
	}
	
	@GetMapping("/cursos/eliminar/{id}")
	public String borrarCurso(Model model, @PathVariable Integer id) {
		cursoService.eliminarPorId(id);
		return "redirect:/catalogo/cursos";
	}

}
