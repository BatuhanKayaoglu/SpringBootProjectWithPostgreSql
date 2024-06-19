package com.example.rentACar.business.abstracts;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.responses.GetByIdModelResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelResponse> getAll();
    void Add(CreateModelRequest CreateModelRequest);
    void DeleteBrand(int id);
    GetByIdModelResponse getById(int id);

}
