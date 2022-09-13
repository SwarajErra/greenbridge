package com.greenbridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenbridge.entity.Crop;
import com.greenbridge.entity.Farmer;
import com.greenbridge.repository.CropRepository;
import com.greenbridge.repository.FarmerRepository;

@Service
public class FarmerServiceImplementation implements FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;
	@Autowired
	private CropRepository cropRepository;

	// create farmer
	@Override
	public Farmer createFarmer(Farmer farmer, List<Crop> cropList) throws Exception {

		Farmer localFarmer = farmerRepository.findByfarmerId(farmer.getId());
		if (localFarmer != null) {
			try {
				System.out.println("Farmer is alredy present");
				throw new Exception("Farmer is already present");
			}

			catch (Exception exception) {

				exception.printStackTrace();
			}

		}

		else {
			for (Crop crop : cropList) {
				cropRepository.save(crop);
			}

		}
		farmer.getCrops().addAll(cropList);
		localFarmer = farmerRepository.save(farmer);
		return localFarmer;
	}

	@Override
	public Farmer getFarmerbyId(Integer integer) throws Exception {

		Farmer farmer = farmerRepository.findByfarmerId(integer);
		try {
			if (farmer == null) {
				throw new Exception("Farmer not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return farmer;
	}

	@Override
	public void deleteFarmerById(Integer integer) {
        farmerRepository.deleteById(integer);
		
	}

}
