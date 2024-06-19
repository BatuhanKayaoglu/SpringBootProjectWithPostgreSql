package com.example.rentACar.webAPI.controllers;

import java.util.List;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import org.springframework.web.bind.annotation.*;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;

	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandResponse> getAllBrand()
	{
		List<GetAllBrandResponse> brands=brandService.getAll();
		return brands;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public CreateBrandRequest createBrand(@RequestBody CreateBrandRequest cbr)
	{
		this.brandService.Add(cbr);
		return cbr;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBrand(@PathVariable int id) {
			this.brandService.DeleteBrand(id);
			return new ResponseEntity<>("Başarıyla Silindi", HttpStatus.OK);
	}

	@PostMapping("{id}")
	public GetByIdBrandResponse getById(@PathVariable int id)
	{
		return brandService.getById(id);
	}

	@PutMapping("{id}")
	public void  update(@RequestBody UpdateBrandRequest updateBrandRequest)
	{
		this.brandService.update(updateBrandRequest);
	}

}
