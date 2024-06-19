package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracts.ModelService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllBrandResponse;
import com.example.rentACar.business.responses.GetAllModelResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.responses.GetByIdModelResponse;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ModelRepository;
import com.example.rentACar.entities.concretes.Brand;
import com.example.rentACar.entities.concretes.Model;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> modelList= modelRepository.findAll();
        List<GetAllModelResponse> modelResponse=modelList.stream()
                .map(model -> this.modelMapperService.forResponse().map(model,GetAllModelResponse.class))
                .collect(Collectors.toList());
        return modelResponse;
    }

    @Override
    public void DeleteBrand(int id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id " + id));
        modelRepository.delete(model);
    }

    public void Add(CreateModelRequest CreateModelRequest) {
        Model model=this.modelMapperService.forRequest().map(CreateModelRequest,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public GetByIdModelResponse getById(int id) {
        Model model=this.modelRepository.findById(id).orElseThrow();
        GetByIdModelResponse response=this.modelMapperService.forResponse().map(model,GetByIdModelResponse.class);
        return response;
    }
}
