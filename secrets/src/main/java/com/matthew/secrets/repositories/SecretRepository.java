package com.matthew.secrets.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.secrets.models.Secret;

@Repository
public interface SecretRepository extends CrudRepository<Secret, Long>{
	List<Secret> findFirst10ByOrderByCreatedAtDesc();
}
