package com.matthew.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.cars.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

}
