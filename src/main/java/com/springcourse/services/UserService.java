package com.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domains.User;
import com.springcourse.repositories.UserRepository;
import com.springcourse.services.util.HashUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		return userRepository.save(user);
	}
	
	public User update(User user) {
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);

		return userRepository.save(user);
	}
	
	public User getById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> listAll() {
		return userRepository.findAll();
	}
	
	public User login(String email, String password) {
		password = HashUtil.getSecureHash(password);
		
		return userRepository.login(email, password).get();
	}
}