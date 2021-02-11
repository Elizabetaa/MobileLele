package com.example.mobiLelele.mobiLelele.service.impl;

import com.example.mobiLelele.mobiLelele.model.entities.Brand;
import com.example.mobiLelele.mobiLelele.model.entities.ModelEntity;
import com.example.mobiLelele.mobiLelele.model.view.BrandViewModel;
import com.example.mobiLelele.mobiLelele.model.view.ModelViewModel;
import com.example.mobiLelele.mobiLelele.repositoriy.BrandRepository;
import com.example.mobiLelele.mobiLelele.repositoriy.ModelRepository;
import com.example.mobiLelele.mobiLelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private ModelRepository modelRepository;
    private ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository,
                            ModelMapper modelMapper){
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> result = new ArrayList<>();
        List<ModelEntity> allModelEntities = modelRepository.findAll();

        allModelEntities.forEach(m -> {
            Brand brandEntity = m.getBrand();
            Optional<BrandViewModel> brandViewModel = findByName(result,brandEntity.getName());

            if (brandViewModel.isEmpty()){
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity,newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModel = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(m, newModelViewModel);
            brandViewModel.get().addModel(newModelViewModel);
        });
        return result;
    }


    private static Optional<BrandViewModel> findByName (List<BrandViewModel> allModels, String name){
        return  allModels
                .stream()
                .filter(m -> m.getName().equals(name)).findAny();
    }


}
