package com.example.yearupSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.yearupSpring.models.User;
import com.example.yearupSpring.models.UserRepository;


/**
 * This code represents an introduction to REST API 
 * (Representational state transfer api)
 * This is just for demo, there is no authentication. validation and error handling.
 * 
 * as per spring, docs this is not yet a REST API, just getting there:
 * https://spring.io/guides/tutorials/rest/
 * 
 * 
 * @author edwin
 *
 */


@RestController
public class UserController {
	
	private final UserRepository userRepo;
	
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	
//	Get Request --- this appear on the url, i.e. www.google.com/search?q=query
//	q=query is the first parameter.
	@GetMapping("/users")
	List<User> getAll(){
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	User getUser(@PathVariable Integer id) {
		return userRepo.findById(id).get();
	}
	
	
//	Post parameter appear in the request body. readable but! not directly in browser.
	@PostMapping("/users")
	User addNew(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PutMapping("/users")
	User putUser(@RequestBody User user) {
		
		return userRepo.findById(user.getId()).map(someuser -> {
			someuser.setName(user.getName());
			someuser.setPassword(user.getPassword());
			return userRepo.save(someuser);
		}).orElseGet(()->{
			return userRepo.save(user);
		});
	}
	
	
	@DeleteMapping("/users/{id}")
	void removeUser(@RequestBody Integer id) {
		userRepo.deleteById(id);
	}
	
	
	
	
}
