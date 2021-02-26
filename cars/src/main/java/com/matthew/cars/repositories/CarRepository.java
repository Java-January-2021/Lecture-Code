package com.matthew.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.cars.models.Car;
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
	List<Car> findAll(); // SELECT * FROM cars
	List<Car> findFirst5ByOrderByCreatedAtDesc();
}
