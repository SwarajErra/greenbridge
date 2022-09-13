package com.greenbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenbridge.entity.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

}
