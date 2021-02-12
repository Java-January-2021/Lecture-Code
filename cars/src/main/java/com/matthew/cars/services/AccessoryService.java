package com.matthew.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.cars.models.Accessory;
import com.matthew.cars.repositories.AccessoryRepository;

@Service
public class AccessoryService {
	@Autowired
	private AccessoryRepository aRepo;
	
	// Create
	public Accessory create(Accessory accessory) {
		return this.aRepo.save(accessory);
	}
}
