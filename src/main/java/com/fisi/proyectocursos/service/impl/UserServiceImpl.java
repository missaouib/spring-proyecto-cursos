package com.fisi.proyectocursos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fisi.proyectocursos.model.User;
import com.fisi.proyectocursos.repository.UserRepository;
import com.fisi.proyectocursos.service.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//user.setRoles(new HashSet<>(roleRepository.findAll()));
		
		return userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

}
