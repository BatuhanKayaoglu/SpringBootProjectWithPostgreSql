package com.example.rentACar.business.concretes;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	
	public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
		this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

	@Override
	public List<GetAllBrandResponse> getAll() {
		List<Brand> brandList= brandRepository.findAll();
		List<GetAllBrandResponse> brandsResponse=brandList.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandResponse.class))
				.collect(Collectors.toList());
		return brandsResponse;
	}

	public void Add(CreateBrandRequest CreateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(CreateBrandRequest,Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void DeleteBrand(int id) {
		Brand brand = brandRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Brand not found with id " + id));
		brandRepository.delete(brand);
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand=this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
		return  response;
	}

}
