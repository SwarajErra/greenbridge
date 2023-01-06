package com.greenbridge.controller;

import com.greenbridge.payload.CustomApiResponse;
import com.greenbridge.payload.FarmerDTO;
import com.greenbridge.payload.FarmerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.greenbridge.service.FarmerService;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("api/farmers")
public class FarmerController {
	
	@Autowired
	private FarmerService farmerService;
	
	//create user
	@PostMapping("/")
	public ResponseEntity<FarmerDTO> createFarmer(@Valid @RequestBody FarmerDTO farmerDTO) throws Exception {
		FarmerDTO createdFarmer =	farmerService.createFarmer(farmerDTO);
		return new ResponseEntity<>(createdFarmer, HttpStatus.CREATED);

	}
	@PutMapping("/{farmerID}")
	public ResponseEntity<FarmerDTO> updateFarmer(@Valid @RequestBody FarmerDTO farmerDTO,@PathVariable("farmerID") Integer id) throws Exception {
		 FarmerDTO updatedFarmer  = farmerService.updateFarmer(farmerDTO,id);
		 return ResponseEntity.ok(updatedFarmer);
	}
	@DeleteMapping("/{farmerID}")
	public ResponseEntity<CustomApiResponse> deleteFarmer(@PathVariable("farmerID") Integer id){
		farmerService.deleteFarmerById(id);
		return new ResponseEntity<>(new CustomApiResponse("farmer successfully deleted",true),HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<FarmerDTO> getFarmerById(@PathVariable Integer id) throws Exception {
		FarmerDTO farmerDTO = farmerService.getFarmerbyId(id);
		return ResponseEntity.ok(farmerDTO);
	}
	@GetMapping("/")
	public ResponseEntity<FarmerResponse> getAllFarmers(
			@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = "farmerId",required = false)String sortBy,
			@RequestParam(value = "sortDir",defaultValue = "asc",required = false)String sortDir) throws Exception {
		FarmerResponse farmerResponse = farmerService.getAllFarmers(pageNumber,pageSize,sortBy,sortDir);
		return ResponseEntity.ok(farmerResponse);
	}
	@GetMapping("/search/{firstName}")
	public ResponseEntity<List<FarmerDTO>> searchFarmerbyFirstName(@PathVariable String firstName){
		List<FarmerDTO> farmers =  farmerService.searchFarmers(firstName);
		return ResponseEntity.ok(farmers);
	}
	@GetMapping("/test")
	public String test(){
		return "Test";
	}

}
