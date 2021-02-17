package com.matthew.cars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.cars.models.User;
import com.matthew.cars.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	// Find Single User
	public User find(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> getAllUsers(){
		return this.uRepo.findAll();
	}
}
