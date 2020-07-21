package com.springcourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.domains.User;
import com.springcourse.dto.UserLoginDTO;
import com.springcourse.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public User update(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.update(user);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.FOUND)
	public User getById(@PathVariable("id") Long id) {
		return userService.getById(id);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.FOUND)
	public List<User> listAll() {
		return userService.listAll();
	}
	
	@PostMapping("/login")
	@ResponseStatus(value = HttpStatus.OK)
	public User login(@RequestBody UserLoginDTO user) {
		return userService.login(user.getEmail(), user.getPassword());
	}
}