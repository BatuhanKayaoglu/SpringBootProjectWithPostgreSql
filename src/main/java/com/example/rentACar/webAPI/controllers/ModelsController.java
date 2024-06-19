package com.example.rentACar.webAPI.controllers;

import com.example.rentACar.business.abstracts.ModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllModelResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.responses.GetByIdModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/models")
public class ModelsController {

	private ModelService modelService;

	public ModelsController(ModelService modelService) {
		super();
		this.modelService = modelService;
	}
	
	@GetMapping("/getall")
	public List<GetAllModelResponse> getAllBrand()
	{
		List<GetAllModelResponse> models=modelService.getAll();
		return models;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public CreateModelRequest createModel(@RequestBody CreateModelRequest cmr)
	{
		this.modelService.Add(cmr);
		return cmr;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBrand(@PathVariable int id) {
			this.modelService.DeleteBrand(id);
			return new ResponseEntity<>("Başarıyla Silindi", HttpStatus.OK);
	}

	@PostMapping("{id}")
	public GetByIdModelResponse getById(@PathVariable int id)
	{
		return modelService.getById(id);
	}


}
