package com.matthew.secrets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.secrets.models.Secret;
import com.matthew.secrets.models.User;
import com.matthew.secrets.repositories.SecretRepository;

@Service
public class SecretService {
	@Autowired
	private SecretRepository sRepo;
	
	
	public List<Secret> getSecrets(){
		return this.sRepo.findFirst10ByOrderByCreatedAtDesc();
	}
	
	// Create
	public Secret create(Secret secret) {
		return this.sRepo.save(secret);
	}
	
	// Add Liker To Secret
	public void addLiker(User user, Secret secret) {
		// pull the list of likers from the secret
		List<User> listOfLikers = secret.getLikers();
		listOfLikers.add(user);
		this.sRepo.save(secret);
	}
	
	//Get Single Secret
	public Secret getSingleSecret(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	// Delete Secret
	public void delete(Long id) {
		this.sRepo.existsById(id);
	}
}
