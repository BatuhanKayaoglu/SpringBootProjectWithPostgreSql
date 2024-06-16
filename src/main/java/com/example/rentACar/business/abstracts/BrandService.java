 package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponse;

public interface BrandService {
 List<GetAllBrandResponse> getAll();
 void Add(CreateBrandRequest CreateBrandRequest);
}
