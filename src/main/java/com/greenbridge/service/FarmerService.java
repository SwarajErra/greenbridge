package com.greenbridge.service;

import java.util.List;

import com.greenbridge.entity.Crop;
import com.greenbridge.entity.Farmer;

public interface FarmerService {
	
	//creating Farmer
	public Farmer createFarmer(Farmer farmer, List<Crop> cropList) throws Exception;
	//get Farmer
	
	public Farmer getFarmerbyId(Integer integer) throws Exception;
	
	//delete farmer
	public void deleteFarmerById(Integer integer);

}
