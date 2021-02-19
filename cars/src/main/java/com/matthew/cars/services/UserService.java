package com.matthew.cars.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	
	// Register A User
	public User registerUser(User user) {
		// Generate a has
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// Set the hashed password on the users password field
		user.setPassword(hash);
		// Save that new user and password to the database
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		// Make sure the user logging in is WHO THEY SAY THEY ARE
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		
		// Step2: use bCrypt to check if the password is the same in the db
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
}
