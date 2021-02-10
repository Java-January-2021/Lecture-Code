package com.matthew.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.cars.models.Registration;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}
