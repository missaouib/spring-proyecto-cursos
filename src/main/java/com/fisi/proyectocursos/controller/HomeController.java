package com.fisi.proyectocursos.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fisi.proyectocursos.security.service.SecurityService;

@Controller
public class HomeController {
	
	@Autowired
	private SecurityService securityService;

	@GetMapping("/")
	public String index() {
		if (securityService.isAuthenticated()) {
			Set<String> roles = securityService.getRolesFromUserAuthenticatedUser();
			
			if (roles.contains("ROLE_USER")) return "redirect:/usuario";
			if (roles.contains("ROLE_CENTER")) return "redirect:/catalogo";
		}
		
		return "home";
	}
	
}
