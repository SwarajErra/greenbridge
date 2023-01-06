package com.greenbridge.service;

import com.greenbridge.entity.Farmer;
import com.greenbridge.payload.FarmerDTO;
import com.greenbridge.payload.FarmerResponse;

import java.util.List;

public interface FarmerService {

	//creating Farmer
	public FarmerDTO createFarmer(FarmerDTO farmerDTO) throws Exception;
	//get Farmer
	public FarmerDTO updateFarmer(FarmerDTO farmerDTO,Integer farmerID) throws Exception;
	public FarmerDTO getFarmerbyId(Integer integer) throws Exception;
	public FarmerResponse getAllFarmers(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) throws Exception;
	//delete farmer
	public void deleteFarmerById(Integer integer);
	//search
	public List<FarmerDTO> searchFarmers(String firstName);

}
