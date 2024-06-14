package com.example.rentACar.dataAccess.abstracts;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Brand;


public interface BrandRepository {
  List<Brand> getAll();
}
