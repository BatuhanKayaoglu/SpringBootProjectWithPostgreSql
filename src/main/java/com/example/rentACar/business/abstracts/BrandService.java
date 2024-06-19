 package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;

 public interface BrandService {

 List<GetAllBrandResponse> getAll();
 void Add(CreateBrandRequest CreateBrandRequest);
 void DeleteBrand(int id);
 void update(UpdateBrandRequest updateBrandRequest);
 GetByIdBrandResponse getById(int id);
}
