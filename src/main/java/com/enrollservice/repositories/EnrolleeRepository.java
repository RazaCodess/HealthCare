package com.enrollservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollservice.models.Enrollee;

@Repository
public interface EnrolleeRepository extends  JpaRepository<Enrollee, Long> {
	 
}
