package com.ashokit.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.InsurancePolicy;

public interface InsuranceRepository extends JpaRepository<InsurancePolicy, Integer>{

	@Query(value="select distinct(planName) from InsurancePolicy")
	public List<String> getPlanName();
	
	@Query(value="select distinct(planStatus) from InsurancePolicy")
	public List<String> getPlanStatus();
}
