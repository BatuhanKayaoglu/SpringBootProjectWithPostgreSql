package com.example.rentACar.dataAccess.abstracts;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentACar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByName(String name);
	
}
