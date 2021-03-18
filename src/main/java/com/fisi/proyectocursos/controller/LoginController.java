package com.fisi.proyectocursos.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fisi.proyectocursos.model.Person;
import com.fisi.proyectocursos.model.Role;
import com.fisi.proyectocursos.security.service.SecurityService;
import com.fisi.proyectocursos.service.impl.UserServiceImpl;
import com.fisi.proyectocursos.validators.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (securityService.isAuthenticated()) {
			return "redirect:/";
		}
		
		if (error != null) {
			model.addAttribute("error", "Su correo y contraseña no son válidos.");
		}
		
		if (logout != null) {
			model.addAttribute("message", "Se ha desconectado con éxito.");
		}
		
		return "login";
	}
	
	@GetMapping("/registro")
	public String registro(Model model) {
		if (securityService.isAuthenticated()) {
			return "redirect:/";
		}
		
		model.addAttribute("userForm", new Person()); // new User()
		
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registro(@ModelAttribute("userForm") Person userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "registro";
		}
		
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(1, "ROLE_USER"));
		userForm.setRoles(roles);
		
		userService.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
		
		return "redirect:/";
	}
	
	@GetMapping("/recuperacion")
	public String recuperacion() {
		return "recuperacion";
	}
}
