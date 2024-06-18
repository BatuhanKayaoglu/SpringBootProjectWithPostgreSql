package com.example.rentACar.webAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponse;
import com.example.rentACar.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;

	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping("/getallData")
	public List<GetAllBrandResponse> getAllBrand()
	{
		List<GetAllBrandResponse> brands=brandService.getAll();
		return brands;
	}
	
	@PostMapping("/add")
	public CreateBrandRequest createBrand(CreateBrandRequest cbr)
	{
		this.brandService.Add(cbr);
		return cbr;
	}
	
}
