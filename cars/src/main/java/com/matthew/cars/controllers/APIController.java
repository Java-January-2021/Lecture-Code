package com.matthew.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.cars.models.Car;
import com.matthew.cars.services.CarService;

@RestController
@RequestMapping("/api")
public class APIController {
	// Dependency Injection
	@Autowired
	private CarService cService;
	
	@GetMapping("")
	public List<Car> index(){
		return this.cService.getAllCars();
	}
	
	@GetMapping("/{id}")
	public Car getCar(@PathVariable("id") Long id) {
		return this.cService.getSingleCar(id);
	}
	
	@PostMapping("")
	public Car create(Car car) {
		return this.cService.createCar(car);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable("id") Long id) {
		this.cService.deleteCar(id);
	}
}
