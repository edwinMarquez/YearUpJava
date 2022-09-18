package com.example.yearupSpring.shell;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.example.yearupSpring.YearupSpringApplication;
import com.example.yearupSpring.models.User;
import com.example.yearupSpring.models.UserRepository;



@ShellComponent
public class ShellSample {

	
	@Autowired
	UserRepository userRepo;

	@ShellMethod
	public String queryUsers() {
		List<User> users = userRepo.findAll();
		return Arrays.toString(users.toArray());
	}
	
	
	
	
}
