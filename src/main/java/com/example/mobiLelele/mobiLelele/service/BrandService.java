package com.example.mobiLelele.mobiLelele.service;

import com.example.mobiLelele.mobiLelele.model.entities.Brand;
import com.example.mobiLelele.mobiLelele.model.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {

    List<BrandViewModel> getAllBrands();

}
