package com.fisi.proyectocursos;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fisi.proyectocursos.model.Category;
import com.fisi.proyectocursos.model.Course;
import com.fisi.proyectocursos.model.Role;
import com.fisi.proyectocursos.model.TrainingCenter;
import com.fisi.proyectocursos.service.interfaces.ICategoryService;
import com.fisi.proyectocursos.service.interfaces.ICourseService;
import com.fisi.proyectocursos.service.interfaces.IRoleService;
import com.fisi.proyectocursos.service.interfaces.IUserService;

@SpringBootApplication
public class ProyectoCursosApplication implements CommandLineRunner {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private ICategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCursosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role_user = new Role("ROLE_USER");
		Role role_center = new Role("ROLE_CENTER");
		Role role_admin = new Role("ROLE_ADMIN");
		
		roleService.save(role_user);
		roleService.save(role_center);
		roleService.save(role_admin);
		
		TrainingCenter tc = new TrainingCenter();
		tc.setUsername("empresa");
		tc.setPassword("empresa");
		tc.setName("empresa");
		tc.setRoles(new HashSet<>());
		tc.getRoles().add(role_center);
		
		userService.save(tc);
		
		Category ct1 = new Category("Backend");
		Category ct2 = new Category("Frontend");
		
		categoryService.save(ct1);
		categoryService.save(ct2);
		
		Course c1 = new Course("Java Developer", LocalDate.of(2021, 4, 4), 24, "DOM 09:00 - 12:00", "URL", ct1, tc);
		
		
		courseService.save(c1);
		
		
	}

}
