package com.example.hms.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.models.Suite;

@Repository
public interface SuiteRepository extends CrudRepository<Suite, String> {

	 Optional<Suite> findByName(String name);
}
