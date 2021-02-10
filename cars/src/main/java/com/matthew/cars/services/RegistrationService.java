package com.matthew.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.cars.models.Registration;
import com.matthew.cars.repositories.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository rRepo;
	
	// Create
	public Registration create(Registration registration) {
		return this.rRepo.save(registration);
	}
}
