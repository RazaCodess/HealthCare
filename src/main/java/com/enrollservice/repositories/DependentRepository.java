package com.enrollservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollservice.models.DependentEnrollee;

@Repository
public interface DependentRepository  extends JpaRepository<DependentEnrollee, Long>{

}