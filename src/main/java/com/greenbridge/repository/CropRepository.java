package com.greenbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenbridge.entity.Crop;

public interface CropRepository extends JpaRepository<Crop, Integer> {

}
