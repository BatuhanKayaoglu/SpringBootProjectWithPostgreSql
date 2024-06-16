package com.example.rentACar.business.concretes;



import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponse;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandResponse> getAll() {
		List<Brand> brandList= brandRepository.findAll();
		List<GetAllBrandResponse> brandsResponse=new ArrayList<GetAllBrandResponse>();
		
		for (Brand brand : brandList) {
			GetAllBrandResponse responseItem=new GetAllBrandResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandsResponse.add(responseItem);
		}
		return brandsResponse;
	}

	public void Add(CreateBrandRequest CreateBrandRequest) {
		Brand brand = new Brand();
		brand.setName(CreateBrandRequest.getName());
		this.brandRepository.save(brand);
		
	}

	


}
