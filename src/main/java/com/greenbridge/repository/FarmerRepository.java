package com.greenbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenbridge.entity.Farmer;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
	
	 Farmer findByFarmerId(Integer id);
	 Farmer findByUserName(String userName);

	 List<Farmer> findByFirstNameContaining(String firstName);

}
