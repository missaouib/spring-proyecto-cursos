package com.fisi.proyectocursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	
	@GetMapping("/usuario")
	public String inicioUsuario() {
		return "usuario_home";
	}
	
	@GetMapping("/catalogo")
	public String catalogo() {
		return "catalogo";
	}

}
