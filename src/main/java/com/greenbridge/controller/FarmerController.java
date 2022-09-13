package com.greenbridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenbridge.entity.Farmer;
import com.greenbridge.service.FarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	
	@Autowired
	private FarmerService farmerService;
	
	//create user
	@PostMapping("/")
	public Farmer createFarmer(@RequestBody Farmer farmer) {
		
		return null;
	}

}
