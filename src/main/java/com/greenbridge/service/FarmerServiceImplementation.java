package com.greenbridge.service;

import com.greenbridge.exceptions.ResourceNotFoundException;
import com.greenbridge.payload.FarmerDTO;
import com.greenbridge.payload.FarmerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greenbridge.entity.Farmer;
import com.greenbridge.repository.CropRepository;
import com.greenbridge.repository.FarmerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmerServiceImplementation implements FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;
	@Autowired
	private CropRepository cropRepository;
	@Autowired
	private ModelMapper modelMapper;

	// create farmer
	@Override
	public FarmerDTO createFarmer(FarmerDTO farmerDTO) throws Exception {

		Farmer existingFarmer = farmerRepository.findByFarmerId(farmerDTO.getFarmerId());
		FarmerDTO registeredFarmer = null;
		try {
			if (existingFarmer != null) {
				System.out.println("Farmer is alredy present");
				throw new Exception("Farmer is already present");
			}
			return farmerToFarmerDTO(farmerRepository.save(farmerDTOToFarmer(farmerDTO)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public FarmerDTO updateFarmer(FarmerDTO farmerDTO, Integer farmerID) throws Exception {

		Farmer farmer = farmerRepository.findById(farmerID).orElseThrow((() -> new ResourceNotFoundException("farmer","id",farmerID)));
		farmer = farmerDTOToFarmer(farmerDTO);
		Farmer updatedFarmer = farmerRepository.save(farmer);
		return farmerToFarmerDTO(updatedFarmer);
	}

	@Override
	public FarmerDTO getFarmerbyId(Integer integer) throws Exception {

		Farmer farmer = farmerRepository.findByFarmerId(integer);
		try {
			if (farmer == null) {
				throw new ResourceNotFoundException("Farmer","id",integer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return farmerToFarmerDTO(farmer);
	}

	@Override
	public FarmerResponse getAllFarmers(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {

		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc")){
			sort = Sort.by(sortBy).ascending();
		}
		else{
			sort = Sort.by(sortBy).descending();
		}
		Pageable pageble = PageRequest.of(pageNumber,pageSize, sort);
		Page<Farmer> farmersPage = farmerRepository.findAll(pageble);
		List<Farmer> farmers = farmersPage.getContent();
		List<FarmerDTO> farmerDTOs = farmers.stream().map(this::farmerToFarmerDTO).collect(Collectors.toList());
		FarmerResponse farmerResponse = new FarmerResponse();
		farmerResponse.setFarmerDTOs(farmerDTOs);
		farmerResponse.setPageNumber(farmersPage.getNumber());
		farmerResponse.setPageSize(farmersPage.getSize());
		farmerResponse.setTotalElements(farmersPage.getTotalElements());
		farmerResponse.setTotalPages(farmersPage.getTotalPages());
		farmerResponse.setLastPage(farmersPage.isLast());
		return farmerResponse;
	}
	@Override
	public void deleteFarmerById(Integer integer) {
		Farmer farmer = farmerRepository.findById(integer).orElseThrow(()-> new ResourceNotFoundException("Farmer","id",integer));
        farmerRepository.delete(farmer);
	}

	@Override
	public List<FarmerDTO> searchFarmers(String firstName) {
		List<Farmer> searchedFarmers = farmerRepository.findByFirstNameContaining(firstName);
		List<FarmerDTO> farmerDTOS = searchedFarmers.stream().map(this::farmerToFarmerDTO).collect(Collectors.toList());
		return farmerDTOS;
	}

	private Farmer farmerDTOToFarmer(FarmerDTO farmerDTO){
		return modelMapper.map(farmerDTO,Farmer.class);
	}
	private FarmerDTO farmerToFarmerDTO(Farmer farmer){
		return modelMapper.map(farmer,FarmerDTO.class);
	}

}
