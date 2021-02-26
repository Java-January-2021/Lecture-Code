package com.matthew.secrets.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.secrets.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll(); // SELECT * FROM users
	boolean existsByEmail(String email);
	User findByEmail(String email);
}
