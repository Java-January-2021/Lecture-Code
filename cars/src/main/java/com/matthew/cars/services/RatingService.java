package com.matthew.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.cars.models.Rating;
import com.matthew.cars.repositories.RatingRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository rRepo;
	
	public void createRating(Rating rating) {
		this.rRepo.save(rating);
	}
}
