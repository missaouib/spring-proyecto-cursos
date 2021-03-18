package com.fisi.proyectocursos.service.interfaces;

import com.fisi.proyectocursos.model.User;
import com.fisi.proyectocursos.service.IService;

public interface IUserService extends IService<User> {
	
	User findByUsername(String username);
	boolean existsByUsername(String username);

}
