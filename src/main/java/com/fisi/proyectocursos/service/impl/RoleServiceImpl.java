package com.fisi.proyectocursos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisi.proyectocursos.model.Role;
import com.fisi.proyectocursos.repository.RoleRepository;
import com.fisi.proyectocursos.service.interfaces.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteById(int id) {
		roleRepository.deleteById(id);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id).orElse(null);
	}

}
